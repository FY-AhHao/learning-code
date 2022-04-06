package com.fy.codeDesign.demo11;

/**
 * @description: 懒汉式（线程安全）
 * @author：AhHao
 * @date: 2022/4/6
 */
public class Singleton4 {

    private static Singleton4 instance;

    private Singleton4() {
    }

    public static synchronized Singleton4 getInstance() {
        if (instance != null) {
            return instance;
        }
        instance = new Singleton4();
        return instance;
    }

}
