package com.fy.codeDesign.demo05;

/**
 * @description: 兰陵王
 * @author：AhHao
 * @date: 2022/3/26
 */
public class KingLanling implements ISkill{
    @Override
    public void throwingDarts() {
        System.out.println("兰陵王扔飞镖");
    }

    @Override
    public void invisible() {
        System.out.println("兰陵王隐身");
    }

    @Override
    public void displacement() {
        System.out.println("兰陵王位移");
    }

    @Override
    public void vertigo() {
        System.out.println("兰陵王眩晕敌方英雄");
    }
}
