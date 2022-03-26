package com.fy.codeDesign.demo03;

/**
 * @description: 错误示范扩展类
 * @author：AhHao
 * @date: 2022/3/26
 */
public class OperationExt extends Operation{

    //重写父类方法，从相减改为相加
    @Override
    public double option1(double x, double y) {
        return x + y;
    }

    //两数相加再求乘积
    public double option2(double x, double y,double z) {
        return option1(x, y) * z;
    }
}
