package com.fy.codeDesign.demo08.secondUpgrade.adapter;

import com.fy.codeDesign.demo08.firstUpgrade.EGM;

import java.util.concurrent.TimeUnit;

/**
 * @description: EGM缓存适配器实现类
 * @author：AhHao
 * @date: 2022/3/28
 */
public class EGMCacheAdapter implements ICacheAdapter {

    private EGM egm = new EGM();

    @Override
    public String get(String key) {
        return egm.gain(key);
    }

    @Override
    public void set(String key, String value) {
        egm.set(key, value);
    }

    @Override
    public void set(String key, String value, long timeout, TimeUnit timeUnit) {
        egm.setEx(key, value, timeout, timeUnit);
    }

    @Override
    public void del(String key) {
        egm.delete(key);
    }
}
