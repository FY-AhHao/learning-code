package com.fy.codeDesign.demo03.test;

import com.fy.codeDesign.demo03.Operation;
import com.fy.codeDesign.demo03.OperationExt;
import com.fy.codeDesign.demo03.OperationExt2;

/**
 * @description:
 * @author：AhHao
 * @date: 2022/3/26
 */
public class ApiTest {

    public static void main(String[] args) {
        System.out.println("--------------------Operation基类---------------------------");
        Operation operation = new Operation();
        double v = operation.option1(10, 1);
        System.out.println("调用方A 10 - 1 = " + v);

        System.out.println("--------------------OperationExt扩展类---------------------------");
        OperationExt operationExt = new OperationExt();
        double v1 = operationExt.option1(10, 1);
        System.out.println("调用方A 10 - 1 = " + v1);
        double v2 = operationExt.option2(10, 1, 10);
        System.out.println("调用方B (10 + 1) * 10 = " + v2);

        System.out.println("--------------------OperationExt2扩展类---------------------------");
        OperationExt2 operationExt2 = new OperationExt2();
        double v3 = operationExt2.option1(10, 1);
        System.out.println("调用方A 10 - 1 = " + v3);
        double v4 = operationExt2.option2(10, 1, 10);
        System.out.println("调用方B (10 - 1) * 10 = " + v4);

    }

}
