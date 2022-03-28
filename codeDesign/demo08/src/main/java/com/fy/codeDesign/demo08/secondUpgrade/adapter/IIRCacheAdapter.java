package com.fy.codeDesign.demo08.secondUpgrade.adapter;

import com.fy.codeDesign.demo08.secondUpgrade.IIR;

import java.util.concurrent.TimeUnit;

/**
 * @description: IIR缓存适配器实现类
 * @author：AhHao
 * @date: 2022/3/28
 */
public class IIRCacheAdapter implements ICacheAdapter {

    private IIR iir = new IIR();

    @Override
    public String get(String key) {
        return iir.get(key);
    }

    @Override
    public void set(String key, String value) {
        iir.set(key, value);
    }

    @Override
    public void set(String key, String value, long timeout, TimeUnit timeUnit) {
        iir.setExpire(key, value, timeout, timeUnit);
    }

    @Override
    public void del(String key) {
        iir.remove(key);
    }
}
