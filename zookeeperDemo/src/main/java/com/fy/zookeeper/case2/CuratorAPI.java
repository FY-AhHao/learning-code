package com.fy.zookeeper.case2;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @description: curator api
 * @author：AhHao
 * @date: 2022/3/21
 */
public class CuratorAPI {

    private Logger logger = LoggerFactory.getLogger(CuratorAPI.class);
    private static final String connectString = "192.168.31.132:2181,192.168.31.98:2181,192.168.31.223:2181";
    private static final int sessionTimeout = 2000;
    private static final int connectionTimeout = 2000;

    /**
     * 获取连接
     *
     * @return
     */
    public CuratorFramework getConnection() {
        ExponentialBackoffRetry retryPolicy = new ExponentialBackoffRetry(1000, 3);
        return CuratorFrameworkFactory.newClient(connectString, sessionTimeout, connectionTimeout, retryPolicy);
    }

    /**
     * 获取孩子节点
     *
     * @param path
     */
    public void getChildren(String path) {
        CuratorFramework connection = getConnection();
        try {
            connection.start();
            List<String> children = connection.getChildren().forPath(path);
            logger.info("孩子列表：{}", children);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }

    /**
     * 创建节点
     *
     * @param path
     * @param value
     */
    public void create(String path, byte[] value) {
        CuratorFramework connection = getConnection();
        try {
            connection.start();
            String s = connection.create()
                    .creatingParentsIfNeeded()
                    .withMode(CreateMode.PERSISTENT)
                    .forPath(path, value);
            logger.info("创建结果：{}", s);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }

    /**
     * 获取节点值
     *
     * @param path
     */
    public void getValue(String path) {
        CuratorFramework connection = getConnection();
        try {
            connection.start();
            byte[] bytes = connection.getData().forPath(path);
            logger.info("节点值：{}", new String(bytes));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }

    /**
     * 设置节点值
     *
     * @param path
     * @param value
     */
    public void setValue(String path, byte[] value) {
        CuratorFramework connection = getConnection();
        try {
            connection.start();
            connection.setData().forPath(path, value);
            logger.info("设置成功");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }

    /**
     * @param path
     * @param value
     */
    public void setValueAsync(String path, byte[] value) {
        CuratorFramework connection = getConnection();
        try {
            connection.start();
            connection.setData()
                    .inBackground((curatorFramework, curatorEvent) -> {
                        logger.info("type:{},code:{}",curatorEvent.getType(),curatorEvent.getResultCode());
                    })
                    .forPath(path, value);
            logger.info("设置成功");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }

    /**
     * 删除节点
     *
     * @param path
     */
    public void delete(String path) {
        CuratorFramework connection = getConnection();
        try {
            connection.start();
            connection.delete().forPath(path);
            logger.info("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }

    /**
     * 节点是否存在
     *
     * @param path
     */
    public void exists(String path) {
        CuratorFramework connection = getConnection();
        try {
            connection.start();
            Stat exists = connection.checkExists().forPath(path);
            logger.info("{} -- {}", path, exists == null ? "不存在" : "存在");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }
}
