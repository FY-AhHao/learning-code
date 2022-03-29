package com.fy.codeDesign.demo09.decorationPackage;

import com.fy.codeDesign.demo09.matter.Matter;
import com.fy.codeDesign.demo09.matter.ceiling.LevelOneCeiling;
import com.fy.codeDesign.demo09.matter.ceiling.LevelTwoCeiling;
import com.fy.codeDesign.demo09.matter.coat.DuluxCoat;
import com.fy.codeDesign.demo09.matter.coat.LiBangCoat;
import com.fy.codeDesign.demo09.matter.floor.ShengxiangFloor;
import com.fy.codeDesign.demo09.matter.tile.DongPengTile;
import com.fy.codeDesign.demo09.matter.tile.MarcoPoloTile;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: 装修清单
 * @author：AhHao
 * @date: 2022/3/29
 */
public class DecorationPackageCtl {

    public String getMatterList(BigDecimal area, Integer level) {
        //装修清单
        List<Matter> list = new ArrayList<>();
        //价格
        BigDecimal price = BigDecimal.ZERO;

        //豪华欧式
        if (1 == level) {
            //二级吊顶
            LevelTwoCeiling levelTwoCeiling = new LevelTwoCeiling();
            //多乐士涂料
            DuluxCoat duluxCoat = new DuluxCoat();
            //圣象地板
            ShengxiangFloor shengxiangFloor = new ShengxiangFloor();

            list.add(levelTwoCeiling);
            list.add(duluxCoat);
            list.add(shengxiangFloor);

            price = price.add(area.multiply(new BigDecimal("0.2")).multiply(levelTwoCeiling.price()));
            price = price.add(area.multiply(new BigDecimal("1.4")).multiply(duluxCoat.price()));
            price = price.add(area.multiply(shengxiangFloor.price()));
        }

        //轻奢田园
        if (2 == level) {
            //二级吊顶
            LevelTwoCeiling levelTwoCeiling = new LevelTwoCeiling();
            //立邦涂料
            LiBangCoat liBangCoat = new LiBangCoat();
            //马可波罗地砖
            MarcoPoloTile marcoPoloTile = new MarcoPoloTile();

            list.add(levelTwoCeiling);
            list.add(liBangCoat);
            list.add(marcoPoloTile);

            price = price.add(area.multiply(new BigDecimal("0.2")).multiply(levelTwoCeiling.price()));
            price = price.add(area.multiply(new BigDecimal("1.4")).multiply(liBangCoat.price()));
            price = price.add(area.multiply(marcoPoloTile.price()));
        }

        //现代简约
        if (3 == level) {
            //一级吊顶
            LevelOneCeiling levelOneCeiling = new LevelOneCeiling();
            //立邦涂料
            LiBangCoat liBangCoat = new LiBangCoat();
            //马可波罗地砖
            DongPengTile dongPengTile = new DongPengTile();

            list.add(levelOneCeiling);
            list.add(liBangCoat);
            list.add(dongPengTile);

            price = price.add(area.multiply(new BigDecimal("0.2")).multiply(levelOneCeiling.price()));
            price = price.add(area.multiply(new BigDecimal("1.4")).multiply(liBangCoat.price()));
            price = price.add(area.multiply(dongPengTile.price()));
        }

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
