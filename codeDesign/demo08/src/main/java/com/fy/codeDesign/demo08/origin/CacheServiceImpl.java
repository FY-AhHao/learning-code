package com.fy.codeDesign.demo08.origin;

import java.util.concurrent.TimeUnit;

/**
 * @description: 缓存实现类
 * @author：AhHao
 * @date: 2022/3/28
 */
public class CacheServiceImpl implements ICacheService {

    private RedisUtil redisUtil = new RedisUtil();

    @Override
    public String get(String key) {
        return redisUtil.get(key);
    }

    @Override
    public void set(String key, String value) {
        redisUtil.set(key, value);
    }

    @Override
    public void set(String key, String value, long timeout, TimeUnit timeUnit) {
        redisUtil.set(key, value,timeout,timeUnit);
    }

    @Override
    public void del(String key) {
        redisUtil.del(key);
    }
}
