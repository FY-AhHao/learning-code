package com.fy.codeDesign.demo07;

import com.fy.codeDesign.demo07.card.IQiYiCardService;
import com.fy.codeDesign.demo07.coupon.CouponService;
import com.fy.codeDesign.demo07.factory.AwardFactory;
import com.fy.codeDesign.demo07.factory.IAwardService;
import com.fy.codeDesign.demo07.goods.GoodsService;

/**
 * @description:
 * @author：AhHao
 * @date: 2022/3/27
 */
public class PrizeCtl {

    //一把嗦发奖方法
    public boolean awardToUser(int type) {
        if (type == 1) {
            IQiYiCardService iQiYiCardService = new IQiYiCardService();
            boolean result = iQiYiCardService.grantToken();
            System.out.println("发放爱奇艺会员卡成功");
            return true;
        } else if (type == 2) {
            CouponService couponService = new CouponService();
            boolean result = couponService.sendCoupon();
            System.out.println("发放优惠券一张成功");
            return true;
        } else if (type == 3) {
            GoodsService goodsService = new GoodsService();
            boolean result = goodsService.deliverGoods();
            System.out.println("模拟发放实物奖品成功");
            return true;
        } else {
            System.out.println("发奖类型错误，发奖失败");
            return false;
        }
    }

    //工厂方法模式发奖方法
    public boolean award(int type){
        AwardFactory awardFactory = new AwardFactory();
        IAwardService awardService = awardFactory.getAwardService(type);
        boolean award = awardService.award();
        System.out.println("发奖成功");
        return true;
    }
}
