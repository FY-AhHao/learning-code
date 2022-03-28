package com.fy.codeDesign.demo08.firstUpgrade;

import com.fy.codeDesign.demo08.origin.RedisUtil;

import java.util.concurrent.TimeUnit;

/**
 * @description: 第一次升级缓存实现类
 * @author：AhHao
 * @date: 2022/3/28
 */
public class CacheClusterServiceImpl implements ICacheService {

    private RedisUtil redisUtil = new RedisUtil();

    private EGM egm = new EGM();


    @Override
    public String get(String key, int redisType) {
        if (redisType == 1){
            return egm.gain(key);
        }

        return redisUtil.get(key);
    }

    @Override
    public void set(String key, String value, int redisType) {
        if (redisType == 1){
            egm.set(key, value);
            return;
        }

        redisUtil.set(key, value);
    }

    @Override
    public void set(String key, String value, long timeout, TimeUnit timeUnit, int redisType) {
        if (redisType == 1){
            egm.setEx(key, value,timeout,timeUnit);
            return;
        }

        redisUtil.set(key, value,timeout,timeUnit);
    }

    @Override
    public void del(String key, int redisType) {
        if (redisType == 1){
            egm.delete(key);
            return;
        }

        redisUtil.del(key);
    }
}
