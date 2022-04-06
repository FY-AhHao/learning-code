package com.fy.codeDesign.demo11;

/**
 * @description: 内部类
 * @author：AhHao
 * @date: 2022/4/6
 */
public class Singleton6 {

    private static class Singleton6Holder {
        private static Singleton6 instance = new Singleton6();
    }

    private Singleton6() {
    }

    public static Singleton6 getInstance() {
        return Singleton6Holder.instance;
    }

}
