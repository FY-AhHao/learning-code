package com.fy.codeDesign.demo07.factory;

import com.fy.codeDesign.demo07.goods.GoodsService;

/**
 * @description: 商品服务
 * @author：AhHao
 * @date: 2022/3/27
 */
public class GoodsAwardService implements IAwardService {
    @Override
    public boolean award() {
        GoodsService goodsService = new GoodsService();
        return goodsService.deliverGoods();
    }
}
