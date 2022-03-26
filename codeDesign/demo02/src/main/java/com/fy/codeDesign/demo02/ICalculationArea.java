package com.fy.codeDesign.demo02;

/**
 * @description: 面积计算接口
 * @author：AhHao
 * @date: 2022/3/26
 */
public interface ICalculationArea {

    double rectangle(double x, double y);

    double triangle(double x, double y, double z);

    double circular(double r);
}
