package com.fy.zookeeper.case2;

import com.fy.zookeeper.case0.NativeAPI;

/**
 * @description: 测试原生api
 * @author：AhHao
 * @date: 2022/3/20
 */
public class CuratorAPITest {


    public static void main(String[] args) {
        CuratorAPI curatorAPI = new CuratorAPI();

        //获取根目录下所有节点
        curatorAPI.getChildren("/");

        //创建节点
        curatorAPI.create("/testNode","hello".getBytes());

        //判断节点是否存在
        curatorAPI.exists("/testNode");

        //获取节点值
        curatorAPI.getValue("/testNode");

        //再次获取根目录下所有节点
        curatorAPI.getChildren("/");

        //设置节点值
        curatorAPI.setValue("/testNode","hello hello".getBytes());

        //再次获取节点值
        curatorAPI.getValue("/testNode");

        //异步设置节点值
        curatorAPI.setValueAsync("/testNode","hello hello async".getBytes());

        //再次获取节点值
        curatorAPI.getValue("/testNode");

        //删除节点
        curatorAPI.delete("/testNode");

        //判断节点是否存在
        curatorAPI.exists("/testNode");

        //再次获取根目录下所有节点
        curatorAPI.getChildren("/");

    }


}
