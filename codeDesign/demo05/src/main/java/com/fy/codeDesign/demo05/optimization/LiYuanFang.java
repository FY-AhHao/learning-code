package com.fy.codeDesign.demo05.optimization;

/**
 * @description: 李元芳
 * @author：AhHao
 * @date: 2022/3/26
 */
public class LiYuanFang implements ISkillDisplacement,ISkillThrowingDarts {

    @Override
    public void throwingDarts() {
        System.out.println("李元芳扔飞镖");
    }

    @Override
    public void displacement() {
        System.out.println("李元芳翻滚");
    }

}
