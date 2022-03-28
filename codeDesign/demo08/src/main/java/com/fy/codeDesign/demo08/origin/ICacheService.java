package com.fy.codeDesign.demo08.origin;

import java.util.concurrent.TimeUnit;

/**
 * @description: 缓存接口
 * @author：AhHao
 * @date: 2022/3/28
 */
public interface ICacheService {

    String get(String key);

    void set(String key,String value);

    void set(String key, String value, long timeout, TimeUnit timeUnit);

    void del(String key);
}
