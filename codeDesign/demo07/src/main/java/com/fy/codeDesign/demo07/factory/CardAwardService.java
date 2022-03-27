package com.fy.codeDesign.demo07.factory;

import com.fy.codeDesign.demo07.card.IQiYiCardService;

/**
 * @description: 爱奇艺兑换卡服务
 * @author：AhHao
 * @date: 2022/3/27
 */
public class CardAwardService implements IAwardService{
    @Override
    public boolean award() {
        IQiYiCardService iQiYiCardService = new IQiYiCardService();
        return iQiYiCardService.grantToken();
    }
}
