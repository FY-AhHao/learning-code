package com.fy.codeDesign.demo09.matter.tile;

import com.fy.codeDesign.demo09.matter.Matter;

import java.math.BigDecimal;

/**
 * @description: 东鹏瓷砖
 * @author：AhHao
 * @date: 2022/3/29
 */
public class DongPengTile implements Matter {
    @Override
    public String scene() {
        return "地砖";
    }

    @Override
    public String brand() {
        return "东鹏";
    }

    @Override
    public String model() {
        return "10001";
    }

    @Override
    public BigDecimal price() {
        return new BigDecimal(102);
    }

    @Override
    public String desc() {
        return "东鹏瓷砖以品质铸就品牌，科技推动品牌，口碑传播品牌为宗旨，2014年品牌价值132.35亿元，位列建陶行业榜首。";
    }
}
