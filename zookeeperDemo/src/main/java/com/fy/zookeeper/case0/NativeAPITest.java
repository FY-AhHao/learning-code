package com.fy.zookeeper.case0;

/**
 * @description: 测试原生api
 * @author：AhHao
 * @date: 2022/3/20
 */
public class NativeAPITest {


    public static void main(String[] args) {
        NativeAPI nativeAPI = new NativeAPI();

        //获取连接
        nativeAPI.getConnection();

        //获取根目录下所有节点
        nativeAPI.getChildren("/");

        //创建节点
        nativeAPI.create("/testNode","hello".getBytes());

        //判断节点是否存在
        nativeAPI.exists("/testNode");

        //获取节点值
        nativeAPI.getValue("/testNode");

        //再次获取根目录下所有节点
        nativeAPI.getChildren("/");

        //设置节点值
        nativeAPI.setValue("/testNode","hello hello".getBytes());

        //再次获取节点值
        nativeAPI.getValue("/testNode");

        //删除节点
        nativeAPI.delete("/testNode");

        //判断节点是否存在
        nativeAPI.exists("/testNode");

        //再次获取根目录下所有节点
        nativeAPI.getChildren("/");

    }


}
