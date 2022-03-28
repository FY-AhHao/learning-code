package com.fy.codeDesign.demo08.secondUpgrade.factory;

import com.fy.codeDesign.demo08.secondUpgrade.adapter.ICacheAdapter;

import java.lang.reflect.Proxy;

/**
 * @description: 通过jdk代理实现抽象工厂
 * @author：AhHao
 * @date: 2022/3/28
 */
public class JDKProxyFactory {


    //理解为超级工厂生产ICacheService工厂，ICacheService工厂生产ICacheAdapter实例化对象
    public static <T> T getProxy(Class<T> clazz, Class<? extends ICacheAdapter> cacheAdapter) throws Exception {
        JDKInvocationHandler invocationHandler = new JDKInvocationHandler(cacheAdapter.newInstance());
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        return (T) Proxy.newProxyInstance(contextClassLoader,new Class[]{clazz},invocationHandler);
    }

}
