package com.fy.codeDesign.demo11;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @description: cas
 * @author：AhHao
 * @date: 2022/4/6
 */
public class Singleton7 {

    private static final AtomicReference<Singleton7> INSTANCE = new AtomicReference<>();

    private static Singleton7 instance;

    private Singleton7() {
    }

    public static final Singleton7 getInstance() {
        for (;;){
            Singleton7 singleton7 = INSTANCE.get();
            if (singleton7 != null) {
                return singleton7;
            }

            INSTANCE.compareAndSet(null,new Singleton7());
            return INSTANCE.get();
        }

    }

}
