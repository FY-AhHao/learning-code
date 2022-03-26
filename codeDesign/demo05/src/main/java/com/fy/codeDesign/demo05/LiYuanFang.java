package com.fy.codeDesign.demo05;

/**
 * @description: 李元芳
 * @author：AhHao
 * @date: 2022/3/26
 */
public class LiYuanFang implements ISkill{

    @Override
    public void throwingDarts() {
        System.out.println("李元芳扔飞镖");
    }

    @Override
    public void invisible() {
        //没有隐身
    }

    @Override
    public void displacement() {
        System.out.println("李元芳翻滚");
    }

    @Override
    public void vertigo() {
        //没有眩晕
    }

}
