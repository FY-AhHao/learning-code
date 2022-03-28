package com.fy.codeDesign.demo08.origin;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * @description: 模拟redis服务
 * @author：AhHao
 * @date: 2022/3/28
 */
public class RedisUtil {

    private Map<String, String> dataMap = new ConcurrentHashMap<>();

    public String get(String key) {
        System.out.println("从redis获取数据 key：" + key);
        return dataMap.get(key);
    }

    public void set(String key, String value) {
        System.out.println("向redis设置数据 key：" + key + "value：" + value);
        dataMap.put(key, value);
    }

    public void set(String key, String value, long timeout, TimeUnit timeUnit) {
        System.out.println("向redis设置数据 key：" + key + "value：" + value + "timeout：" + timeout + "timeUnit：" + timeUnit);
        dataMap.put(key, value);
    }

    public void del(String key) {
        System.out.println("从redis删除数据 key：" + key);
        dataMap.remove(key);
    }


}
