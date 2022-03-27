package com.fy.codeDesign.demo07;

/**
 * @description:
 * @author：AhHao
 * @date: 2022/3/27
 */
public class ApiTest {

    public static void main(String[] args) {
        System.out.println("--------------------不使用设计模式--------------------------");
        PrizeCtl prizeCtl = new PrizeCtl();
        prizeCtl.awardToUser(1);
        prizeCtl.awardToUser(2);
        prizeCtl.awardToUser(3);

        System.out.println("--------------------使用工厂方法模式--------------------------");
        prizeCtl.award(1);
        prizeCtl.award(2);
        prizeCtl.award(3);
    }
}
