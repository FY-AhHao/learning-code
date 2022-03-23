package com.fy.zookeeper.case0;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @description: 原生api
 * @author：AhHao
 * @date: 2022/3/20
 */
public class NativeAPI {

    private Logger logger = LoggerFactory.getLogger(NativeAPI.class);
    private static final String connectString = "192.168.31.132:2181,192.168.31.98:2181,192.168.31.223:2181";
    private static final int sessionTimeout = 2000;
    private final CountDownLatch countDownLatch = new CountDownLatch(1);
    private ZooKeeper zooKeeper;

    /**
     * 获取连接
     */
    public void getConnection() {
        try {
            zooKeeper = new ZooKeeper(connectString, sessionTimeout, event -> {
                if (Watcher.Event.KeeperState.SyncConnected == event.getState()) {
                    //连接成功，放行
                    countDownLatch.countDown();
                }
            });
            //阻塞等待连接
            countDownLatch.await();

            logger.info("连接成功");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取孩子节点
     *
     * @param path
     */
    public void getChildren(String path) {
        try {
            List<String> children = zooKeeper.getChildren(path, false);
            logger.info("孩子节点：{}", children);
        } catch (KeeperException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建节点
     *
     * @param path
     * @param value
     */
    public void create(String path, byte[] value) {
        String s = null;
        try {
            s = zooKeeper.create(path, value, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            logger.info("创建结果：{}", s);
        } catch (KeeperException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取节点值
     *
     * @param path
     */
    public void getValue(String path) {
        try {
            byte[] data = zooKeeper.getData(path, false, null);
            String val = new String(data);
            logger.info("节点值：{}", val);
        } catch (KeeperException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 设置节点值
     *
     * @param path
     * @param value
     */
    public void setValue(String path, byte[] value) {
        try {
            zooKeeper.setData(path, value, -1);
            logger.info("设置成功");
        } catch (KeeperException | InterruptedException e) {
            e.printStackTrace();
        }
    }


    /**
     * 删除节点
     *
     * @param path
     */
    public void delete(String path) {
        try {
            zooKeeper.delete(path, -1);
            logger.info("删除成功");
        } catch (InterruptedException | KeeperException e) {
            e.printStackTrace();
        }
    }

    /**
     * 节点是否存在
     *
     * @param path
     */
    public void exists(String path) {
        try {
            Stat exists = zooKeeper.exists(path, false);
            logger.info("{} -- {}", path, exists == null ? "不存在" : "存在");
        } catch (KeeperException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
