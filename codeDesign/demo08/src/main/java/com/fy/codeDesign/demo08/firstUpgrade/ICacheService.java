package com.fy.codeDesign.demo08.firstUpgrade;

import java.util.concurrent.TimeUnit;

/**
 * @description: 第一次升级缓存接口
 * @author：AhHao
 * @date: 2022/3/28
 */
public interface ICacheService {

    String get(String key,int redisType);

    void set(String key,String value,int redisType);

    void set(String key, String value, long timeout, TimeUnit timeUnit,int redisType);

    void del(String key,int redisType);

}
