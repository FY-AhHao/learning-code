package com.fy.zookeeper.case4;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @description: f分布式锁
 * @author：AhHao
 * @date: 2022/3/20
 */
public class DistributeLock {

    private Logger logger = LoggerFactory.getLogger(DistributeLock.class);
    private static final String connectString = "192.168.31.132:2181,192.168.31.98:2181,192.168.31.223:2181";
    private static final int sessionTimeout = 2000;
    private static final String rootNode = "/lock";
    private static final String subNode = "/seq-";
    //等待节点全路径
    private String watchNode;
    //当前创建的节点全路径
    private String currentNode;
    private final ZooKeeper zooKeeper;

    private final CountDownLatch connectCountDownLatch = new CountDownLatch(1);
    private final CountDownLatch waitCountDownLatch = new CountDownLatch(1);

    public DistributeLock() throws Exception {
        zooKeeper = new ZooKeeper(connectString, sessionTimeout, new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                //建立连接后，唤醒等待的线程
                if (event.getState() == Event.KeeperState.SyncConnected) {
                    connectCountDownLatch.countDown();
                }

                //当发生删除事件且删除的是当前节点的前一个节点时，唤醒等待的线程
                if (event.getType() == Event.EventType.NodeDeleted
                    && event.getPath().equals(watchNode)){
                    waitCountDownLatch.countDown();
                }
            }
        });

        //等待连接
        connectCountDownLatch.await();

        Stat exists = zooKeeper.exists(rootNode, false);
        if (exists == null) {
            logger.info("根节点不存在，创建根节点");
            zooKeeper.create(rootNode,null, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        }
    }

    /**
     * 加锁
     */
    public void zkLock() throws Exception {
        //创建一个短暂顺序节点
        currentNode = zooKeeper.create(rootNode + subNode,null, ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.EPHEMERAL_SEQUENTIAL);

        //获取所有子节点
        List<String> children = zooKeeper.getChildren(rootNode, false);

        //如果大于1个节点，说明有多个客户端要获取锁
        if (children.size() > 1) {

            //所有子节点从小到大排序
            Collections.sort(children);

            //当前创建的节点不是第一个子节点则监听当前节点的前一个节点
            String createdNode = currentNode.substring((rootNode + "/").length());
            if (!createdNode.equals(children.get(0))) {
                //当前client等待的节点
                int idx = children.indexOf(createdNode) - 1;
                String waitNode = children.get(idx);

                //要监听的节点全路径
                watchNode = rootNode + "/" + waitNode;
                zooKeeper.getData(watchNode,true,new Stat());
                //等待锁
                waitCountDownLatch.await();
            }
        }
    }

    /**
     * 解锁
     */
    public void zkUnLock() throws Exception {
        zooKeeper.delete(currentNode,-1);
    }
}
