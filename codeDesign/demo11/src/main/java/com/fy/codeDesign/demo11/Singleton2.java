package com.fy.codeDesign.demo11;

/**
 * @description: 饿汉式
 * @author：AhHao
 * @date: 2022/4/6
 */
public class Singleton2 {

    private static Singleton2 instance = new Singleton2();

    private Singleton2(){}

    public static Singleton2 getInstance(){
        return instance;
    }

}
