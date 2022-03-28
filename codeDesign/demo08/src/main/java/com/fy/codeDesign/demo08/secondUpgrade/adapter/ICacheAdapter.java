package com.fy.codeDesign.demo08.secondUpgrade.adapter;

import java.util.concurrent.TimeUnit;

/**
 * @description: 缓存适配器
 * @author：AhHao
 * @date: 2022/3/28
 */
public interface ICacheAdapter {

    String get(String key);

    void set(String key,String value);

    void set(String key, String value, long timeout, TimeUnit timeUnit);

    void del(String key);

}
