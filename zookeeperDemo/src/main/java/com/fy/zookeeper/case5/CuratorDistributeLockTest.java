package com.fy.zookeeper.case5;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @description: Curator框架分布式锁测试
 * @author：AhHao
 * @date: 2022/3/20
 */
public class CuratorDistributeLockTest {

    private static Logger logger = LoggerFactory.getLogger(CuratorDistributeLockTest.class);
    private static final String connectString = "192.168.31.132:2181,192.168.31.98:2181,192.168.31.223:2181";
    private static final int connectTimeout = 2000;
    private static final int sessionTimeout = 2000;
    private static final String rootNode = "/lock";

    public static void main(String[] args) {
        //客户端1的分布式锁
        InterProcessMutex lock1 = new InterProcessMutex(getCuratorFramework(), rootNode);
        //客户端2的分布式锁
        InterProcessMutex lock2 = new InterProcessMutex(getCuratorFramework(), rootNode);

        new Thread(()->{
            try {
                lock1.acquire();
                logger.info("客户端1 获取锁成功");
                lock1.acquire();
                logger.info("客户端1 再次获取锁成功");

                logger.info("客户端1 处理业务");
                Thread.sleep(5 * 1000);

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    lock1.release();
                    logger.info("客户端1 释放锁成功");
                    lock1.release();
                    logger.info("客户端1 再次释放锁成功");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(()->{
            try {
                lock2.acquire();
                logger.info("客户端2 获取锁成功");
                lock2.acquire();
                logger.info("客户端2 再次获取锁成功");

                logger.info("客户端2 处理业务");
                Thread.sleep(5 * 1000);

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    lock2.release();
                    logger.info("客户端2 释放锁成功");
                    lock2.release();
                    logger.info("客户端2 再次释放锁成功");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

    private static CuratorFramework getCuratorFramework() {
        ExponentialBackoffRetry exponentialBackoffRetry = new ExponentialBackoffRetry(3000,3);
        CuratorFramework curatorFramework = CuratorFrameworkFactory.builder()
                .connectString(connectString)
                .connectionTimeoutMs(connectTimeout)
                .sessionTimeoutMs(sessionTimeout)
                .retryPolicy(exponentialBackoffRetry)
                .build();

        curatorFramework.start();

        return curatorFramework;
    }
}
