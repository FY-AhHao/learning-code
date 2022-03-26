package com.fy.codeDesign.demo02;

/**
 * @description: 面积计算扩展类
 * @author：AhHao
 * @date: 2022/3/26
 */
public class CalculationAreaExt extends CalculationArea {

    @Override
    public double circular(double r) {
        return Math.PI * r * r;
    }

}
