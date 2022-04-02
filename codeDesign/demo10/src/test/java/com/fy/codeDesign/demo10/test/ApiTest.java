package com.fy.codeDesign.demo10.test;

import com.fy.codeDesign.demo10.generatePager.QuestionBankCtl;
import com.fy.codeDesign.demo10.prototypeMode.QuestionnaireCtl;

/**
 * @description:
 * @author：AhHao
 * @date: 2022/4/2
 */
public class ApiTest {

    public static void main(String[] args) throws CloneNotSupportedException {
        QuestionBankCtl questionBankCtl = new QuestionBankCtl();
        System.out.println(questionBankCtl.create("张三", "10001"));
        System.out.println(questionBankCtl.create("李四", "10002"));

        System.out.println("----------------------------原型模式-----------------------------------");
        QuestionnaireCtl questionnaireCtl = new QuestionnaireCtl();
        System.out.println(questionnaireCtl.createPager("张三", "10001"));
        System.out.println(questionnaireCtl.createPager("李四", "10002"));
    }
}
