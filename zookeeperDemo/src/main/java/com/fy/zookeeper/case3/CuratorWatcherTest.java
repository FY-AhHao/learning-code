package com.fy.zookeeper.case3;

/**
 * @description: 监听测试
 * @author：AhHao
 * @date: 2022/3/22
 */
public class CuratorWatcherTest {

    public static void main(String[] args) {
        CuratorWatcher curatorWatcher = new CuratorWatcher();

        curatorWatcher.simpleWatcher("/testNode");
    }
}
