package com.fy.zookeeper.case1;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @description: 服务端
 * @author：AhHao
 * @date: 2022/3/19
 */
public class DistributeServer {

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
            });

            //阻塞等待连接
            countDownLatch.await();
            logger.info("服务端获取连接成功");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 注册服务
     * @param host
     * @throws Exception
     */
    public void registerServer(String host) throws Exception{
        //创建短暂顺序节点
        String s = zooKeeper.create(parentNode + "/server", host.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
        logger.info("{} {} 已注册 ",host,s);
    }


    public static void main(String[] args) throws Exception {
        DistributeServer distributeServer = new DistributeServer();
        distributeServer.getConnection();
        distributeServer.registerServer("node1");

        //模拟服务运行中
        Thread.sleep(Long.MAX_VALUE);
    }
}
