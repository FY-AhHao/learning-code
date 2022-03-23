package com.fy.zookeeper.case4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @description: 分布式锁测试
 * @author：AhHao
 * @date: 2022/3/20
 */
public class DistributeLockTest {

    private static Logger logger = LoggerFactory.getLogger(DistributeLockTest.class);

    public static void main(String[] args) throws Exception {
        //客户端1的分布式锁
        DistributeLock distributeLock1 = new DistributeLock();
        //客户端2的分布式锁
        DistributeLock distributeLock2 = new DistributeLock();

        //客户端1获取锁
        new Thread(()->{
            try {
                distributeLock1.zkLock();
                logger.info("客户端1 获取锁成功");

                logger.info("客户端1 处理业务");
                Thread.sleep(5 * 1000);

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    distributeLock1.zkUnLock();
                    logger.info("客户端1 释放锁成功");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        //客户端2获取锁
        new Thread(()->{
            try {
                distributeLock2.zkLock();
                logger.info("客户端2 获取锁成功");

                logger.info("客户端2 处理业务");
                Thread.sleep(5 * 1000);

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    distributeLock2.zkUnLock();
                    logger.info("客户端2 释放锁成功");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}
