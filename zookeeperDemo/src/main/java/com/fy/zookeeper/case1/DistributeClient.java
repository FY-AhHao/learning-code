package com.fy.zookeeper.case1;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @description: 客户端
 * @author：AhHao
 * @date: 2022/3/19
 */
public class DistributeClient {

    private Logger logger = LoggerFactory.getLogger(DistributeServer.class);
    private static final String connectString = "192.168.31.132:2181,192.168.31.98:2181,192.168.31.223:2181";
    private static final int sessionTimeout = 2000;
    private final CountDownLatch countDownLatch = new CountDownLatch(1);
    private ZooKeeper zooKeeper;
    private static final String parentNode = "/servers";

    /**
     * 获取连接
     * @return
     * @throws IOException
     */
    public void getConnection(){
        try {
            zooKeeper = new ZooKeeper(connectString, sessionTimeout, watchedEvent -> {
                if (Watcher.Event.KeeperState.SyncConnected == watchedEvent.getState()) {

                    try {
                        Stat exists = zooKeeper.exists(parentNode, false);
                        if (exists == null) {
                            //创建根节点
                            zooKeeper.create(parentNode, null, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
                        }
                    } catch (KeeperException | InterruptedException e) {
                        e.printStackTrace();
                    }

                    //连接成功，放行
                    countDownLatch.countDown();
                }
                logger.info("watchedEvent: type:{},state:{}",watchedEvent.getType(),watchedEvent.getState());
                //再次启动监听
                getServerList();
            });

            //阻塞等待连接
            countDownLatch.await();
            logger.info("客户端获取连接成功");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取服务端地址
     */
    public void getServerList(){
        try {
            //获取服务节点，开启监听
            List<String>  children = zooKeeper.getChildren(parentNode, true);
            //存储服务节点值
            List<String> hosts = new ArrayList<>(children.size());
            for (String child : children) {
                byte[] data = zooKeeper.getData(parentNode + "/" + child, false, null);
                hosts.add(new String(data));
            }
            logger.info("服务端地址：{}",hosts);
        } catch (KeeperException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        DistributeClient distributeClient = new DistributeClient();
        distributeClient.getConnection();
        distributeClient.getServerList();

        //模拟服务运行中
        Thread.sleep(Long.MAX_VALUE);
    }
}
