package com.fy.codeDesign.demo09.matter.ceiling;

import com.fy.codeDesign.demo09.matter.Matter;

import java.math.BigDecimal;

/**
 * @description: 二级吊顶
 * @author：AhHao
 * @date: 2022/3/29
 */
public class LevelTwoCeiling implements Matter {


    @Override
    public String scene() {
        return "吊顶";
    }

    @Override
    public String brand() {
        return "装修公司自带";
    }

    @Override
    public String model() {
        return "二级顶";
    }

    @Override
    public BigDecimal price() {
        return new BigDecimal(850);
    }

    @Override
    public String desc() {
        return "两个层次的吊顶，二级吊顶高度一般就往下吊20cm，要是层高很高，也可增加每级的厚度";
    }
}
