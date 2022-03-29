package com.fy.codeDesign.demo09.matter.coat;

import com.fy.codeDesign.demo09.matter.Matter;

import java.math.BigDecimal;

/**
 * @description: 立邦涂料
 * @author：AhHao
 * @date: 2022/3/29
 */
public class LiBangCoat implements Matter {
    @Override
    public String scene() {
        return "涂料";
    }

    @Override
    public String brand() {
        return "立邦";
    }

    @Override
    public String model() {
        return "默认级别";
    }

    @Override
    public BigDecimal price() {
        return new BigDecimal(650);
    }

    @Override
    public String desc() {
        return "立邦始终以开发绿色产品、注重高科技、高品质为目标，以技术力量不断推进科研和开发，满足消费者需求。";
    }
}
