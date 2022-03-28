package com.fy.codeDesign.demo08.test;

import com.fy.codeDesign.demo08.origin.CacheServiceImpl;
import com.fy.codeDesign.demo08.origin.ICacheService;
import com.fy.codeDesign.demo08.secondUpgrade.adapter.EGMCacheAdapter;
import com.fy.codeDesign.demo08.secondUpgrade.adapter.IIRCacheAdapter;
import com.fy.codeDesign.demo08.secondUpgrade.factory.JDKProxyFactory;

/**
 * @description:
 * @author：AhHao
 * @date: 2022/3/28
 */
public class ApiTest {

    public static void main(String[] args) throws Exception {
        ICacheService cacheService = new CacheServiceImpl();
        cacheService.set("hello","origin cache service");
        cacheService.get("hello");

        ICacheService egm = JDKProxyFactory.getProxy(ICacheService.class, EGMCacheAdapter.class);
        egm.set("hello","egm service");
        egm.get("hello");

        ICacheService iir = JDKProxyFactory.getProxy(ICacheService.class, IIRCacheAdapter.class);
        iir.set("hello","iir service");
        iir.get("hello");
    }
}
