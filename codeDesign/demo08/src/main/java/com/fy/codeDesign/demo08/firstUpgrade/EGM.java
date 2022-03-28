package com.fy.codeDesign.demo08.firstUpgrade;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * @description: 模拟第一次升级后的redis服务
 * @author：AhHao
 * @date: 2022/3/28
 */
public class EGM {

    private Map<String, String> dataMap = new ConcurrentHashMap<>();

    public String gain(String key) {
        System.out.println("从redis(EGM)获取数据 key：" + key);
        return dataMap.get(key);
    }

    public void set(String key, String value) {
        System.out.println("向redis(EGM)设置数据 key：" + key + "value：" + value);
        dataMap.put(key, value);
    }

    public void setEx(String key, String value, long timeout, TimeUnit timeUnit) {
        System.out.println("向redis(EGM)设置数据 key：" + key + "value：" + value + "timeout：" + timeout + "timeUnit：" + timeUnit);
        dataMap.put(key, value);
    }

    public void delete(String key) {
        System.out.println("从redis(EGM)删除数据 key：" + key);
        dataMap.remove(key);
    }


}
