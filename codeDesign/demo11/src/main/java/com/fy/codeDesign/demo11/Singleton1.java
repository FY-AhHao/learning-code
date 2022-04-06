package com.fy.codeDesign.demo11;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description: 静态关键字
 * @author：AhHao
 * @date: 2022/4/6
 */
public class Singleton1 {

    public static Map<String,String> cache = new ConcurrentHashMap<>();
}
