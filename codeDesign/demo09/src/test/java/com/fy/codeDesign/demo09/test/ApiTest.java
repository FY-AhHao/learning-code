package com.fy.codeDesign.demo09.test;

import com.fy.codeDesign.demo09.builder.Builder;
import com.fy.codeDesign.demo09.decorationPackage.DecorationPackageCtl;

import java.math.BigDecimal;

/**
 * @description:
 * @author：AhHao
 * @date: 2022/3/29
 */
public class ApiTest {

    public static void main(String[] args) {
        System.out.println("-------------------------非建造者模式-------------------------------");
        DecorationPackageCtl decorationPackageCtl = new DecorationPackageCtl();
        System.out.println(decorationPackageCtl.getMatterList(new BigDecimal("100.30"), 1));
        System.out.println(decorationPackageCtl.getMatterList(new BigDecimal("80.50"), 2));
        System.out.println(decorationPackageCtl.getMatterList(new BigDecimal("70.30"), 3));

        System.out.println("-------------------------建造者模式-------------------------------");

        Builder builder = new Builder();
        System.out.println(builder.levelOne(new BigDecimal("100.30")).getDetail());
        System.out.println(builder.levelTwo(new BigDecimal("80.50")).getDetail());
        System.out.println(builder.levelThree(new BigDecimal("70.30")).getDetail());
    }
}
