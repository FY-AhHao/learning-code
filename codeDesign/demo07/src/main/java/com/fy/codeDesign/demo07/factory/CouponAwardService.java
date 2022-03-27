package com.fy.codeDesign.demo07.factory;

import com.fy.codeDesign.demo07.coupon.CouponService;

/**
 * @description: 优惠券服务
 * @author：AhHao
 * @date: 2022/3/27
 */
public class CouponAwardService implements IAwardService{
    @Override
    public boolean award() {
        CouponService couponService = new CouponService();
        return couponService.sendCoupon();
    }
}
