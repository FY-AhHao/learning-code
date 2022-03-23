package com.fy.zookeeper.case3;

import com.fy.zookeeper.case2.CuratorAPI;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.CuratorCache;
import org.apache.curator.framework.recipes.cache.CuratorCacheListener;
import org.apache.curator.framework.recipes.cache.NodeCache;
import org.apache.curator.framework.recipes.cache.NodeCacheListener;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.data.Stat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @description: 监听
 * @author：AhHao
 * @date: 2022/3/22
 */
public class CuratorWatcher {

    private Logger logger = LoggerFactory.getLogger(CuratorWatcher.class);
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
     * 简单监听
     */
    public void simpleWatcher(String path){

        CuratorFramework connection = getConnection();
        try {
            connection.start();

            Stat stat = connection.checkExists().forPath(path);
            if (stat == null) {
                connection.create().forPath(path,"init data".getBytes());
            }

            byte[] bytes = connection.getData()
                    .usingWatcher((Watcher) (watchedEvent) -> {
                        logger.info("监听到数据发生变化，type:{},state:{},path:{}",watchedEvent.getType(),watchedEvent.getState(),watchedEvent.getPath());
                    })
                    .forPath(path);
            logger.info("初始节点数据：{}", new String(bytes));


            connection.setData().forPath(path,"first update data".getBytes());
            connection.setData().forPath(path,"second update data".getBytes());

            connection.delete().forPath(path);

            Thread.sleep(Long.MAX_VALUE);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }

    }

}
