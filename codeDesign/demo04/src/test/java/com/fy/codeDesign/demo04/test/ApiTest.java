package com.fy.codeDesign.demo04.test;

import com.fy.codeDesign.demo04.Principal;

import java.util.Map;

/**
 * @description:
 * @author：AhHao
 * @date: 2022/3/26
 */
public class ApiTest {

    public static void main(String[] args) {
        Principal principal = new Principal();
        Map<String, Object> classInfo = principal.getClassInfo();
        System.out.println("classInfo = " + classInfo);
    }
}
