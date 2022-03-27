package com.fy.codeDesign.demo07.card;

import java.util.UUID;

/**
 * @description: 爱奇艺兑换卡服务
 * @author：AhHao
 * @date: 2022/3/27
 */
public class IQiYiCardService {

    //发放会员卡
    public boolean grantToken(){
        String s = UUID.randomUUID().toString();
        System.out.println("模拟发放爱奇艺会员卡一张: " + s);
        return true;
    }
}
