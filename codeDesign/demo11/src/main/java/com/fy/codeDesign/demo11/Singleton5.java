package com.fy.codeDesign.demo11;

/**
 * @description: 懒汉式（线程安全 双重判断）
 * @author：AhHao
 * @date: 2022/4/6
 */
public class Singleton5 {

    private static Singleton5 instance;

    private Singleton5() {
    }

    public static Singleton5 getInstance() {
        if (instance != null) {
            return instance;
        }

        synchronized (Singleton5.class) {
            if (instance != null) {
                return instance;
            }
            instance = new Singleton5();
        }

        return instance;
    }

}
