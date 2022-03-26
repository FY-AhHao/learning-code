package com.fy.codeDesign.demo03;

/**
 * @description: 正确示范扩展类
 * @author：AhHao
 * @date: 2022/3/26
 */
public class OperationExt2 extends Operation{

    //私有方法，两数相加
    private double option(double x,double y){
        return x + y;
    }

    //两数相加再求乘积
    public double option2(double x, double y,double z) {
        return option(x, y) * z;
    }
}
