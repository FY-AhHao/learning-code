package com.fy.codeDesign.demo2.test;

import com.fy.codeDesign.demo02.CalculationArea;
import com.fy.codeDesign.demo02.CalculationAreaExt;
import com.fy.codeDesign.demo02.ICalculationArea;

/**
 * @description:
 * @author：AhHao
 * @date: 2022/3/26
 */
public class ApiTest {

    public static void main(String[] args) {
        System.out.println("------------------原来圆面积计算---------------------");
        ICalculationArea calculationArea = new CalculationArea();
        double circular = calculationArea.circular(10);
        System.out.println("circular = " + circular);
        System.out.println("------------------原来圆面积计算---------------------");
        ICalculationArea calculationAreaExt = new CalculationAreaExt();
        double circular1 = calculationAreaExt.circular(10);
        System.out.println("circular = " + circular1);
    }
}
