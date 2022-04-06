package com.fy.codeDesign.demo11;

/**
 * @description: 懒汉式（线程不安全）
 * @author：AhHao
 * @date: 2022/4/6
 */
public class Singleton3 {

    private static Singleton3 instance;

    private Singleton3() {
    }

    public static Singleton3 getInstance() {
        if (instance != null) {
            return instance;
        }
        instance = new Singleton3();
        return instance;
    }

}
