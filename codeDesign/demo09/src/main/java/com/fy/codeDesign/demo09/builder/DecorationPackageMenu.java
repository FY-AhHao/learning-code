package com.fy.codeDesign.demo09.builder;

import com.fy.codeDesign.demo09.matter.Matter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author：AhHao
 * @date: 2022/3/29
 */
public class DecorationPackageMenu implements IMenu {

    private BigDecimal area;
    private String level;

    //装修清单
    List<Matter> list = new ArrayList<>();
    //价格
    BigDecimal price = BigDecimal.ZERO;

    public DecorationPackageMenu(){}

    public DecorationPackageMenu(BigDecimal area,String level){
        this.area = area;
        this.level = level;
    }

    @Override
    public IMenu appendCeiling(Matter matter) {
        list.add(matter);
        price = price.add(area.multiply(new BigDecimal("0.2")).multiply(matter.price()));
        return this;
    }

    @Override
    public IMenu appendCoat(Matter matter) {
        list.add(matter);
        price = price.add(area.multiply(new BigDecimal("1.4")).multiply(matter.price()));
        return this;
    }

    @Override
    public IMenu appendFloor(Matter matter) {
        list.add(matter);
        price = price.add(area.multiply(matter.price()));
        return this;
    }

    @Override
    public IMenu appendTile(Matter matter) {
        list.add(matter);
        price = price.add(area.multiply(matter.price()));
        return this;
    }

    @Override
    public String getDetail() {
        StringBuilder detail = new StringBuilder("\r\n-----------------------------------------------------------------\r\n" +
                "装修清单：" + "\r\n" +
                "套餐等级：" + level + "\r\n" +
                "套餐价格：" + price.setScale(2,BigDecimal.ROUND_HALF_UP) + "元\r\n" +
                "房屋面积：" + area.doubleValue() + " 平米\r\n" +
                "材料清单：\r\n");

        for (Matter matter : list) {
            detail.append(matter.scene()).append("：")
                    .append(matter.brand()).append("、")
                    .append(matter.model())
                    .append("、平米价格：").append(matter.price()).append(" 元。\n");
        }
        return detail.toString();
    }
}
