package com.fy.codeDesign.demo07.factory;

/**
 * @description: 发奖服务工厂
 * @author：AhHao
 * @date: 2022/3/27
 */
public class AwardFactory {

    //生产发奖服务
    public IAwardService getAwardService(int type) {
        if (type == 1) {
            return new CardAwardService();
        } else if (type == 2) {
            return new CouponAwardService();
        } else if (type == 3) {
            return new GoodsAwardService();
        } else {
            return null;
        }
    }
}
