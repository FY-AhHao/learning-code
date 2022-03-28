package com.fy.codeDesign.demo08.secondUpgrade;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * @description: 模拟第二次升级后的redis服务
 * @author：AhHao
 * @date: 2022/3/28
 */
public class IIR {

    private Map<String, String> dataMap = new ConcurrentHashMap<>();

    public String get(String key) {
        System.out.println("从redis(IIR)获取数据 key：" + key);
        return dataMap.get(key);
    }

    public void set(String key, String value) {
        System.out.println("向redis(IIR)设置数据 key：" + key + "value：" + value);
        dataMap.put(key, value);
    }

    public void setExpire(String key, String value, long timeout, TimeUnit timeUnit) {
        System.out.println("向redis(IIR)设置数据 key：" + key + "value：" + value + "timeout：" + timeout + "timeUnit：" + timeUnit);
        dataMap.put(key, value);
    }

    public void remove(String key) {
        System.out.println("从redis(IIR)删除数据 key：" + key);
        dataMap.remove(key);
    }


}
