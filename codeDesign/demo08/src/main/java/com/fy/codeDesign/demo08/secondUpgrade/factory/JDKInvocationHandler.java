package com.fy.codeDesign.demo08.secondUpgrade.factory;

import com.fy.codeDesign.demo08.secondUpgrade.adapter.ICacheAdapter;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @description:
 * @author：AhHao
 * @date: 2022/3/28
 */
public class JDKInvocationHandler implements InvocationHandler {

    private ICacheAdapter cacheAdapter;

    public JDKInvocationHandler(ICacheAdapter cacheAdapter) {
        this.cacheAdapter = cacheAdapter;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return ICacheAdapter.class.getMethod(method.getName(),method.getParameterTypes()).invoke(cacheAdapter,args);
    }
}
