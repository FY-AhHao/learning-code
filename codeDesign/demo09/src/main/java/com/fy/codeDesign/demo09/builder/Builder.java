package com.fy.codeDesign.demo09.builder;

import com.fy.codeDesign.demo09.matter.ceiling.LevelOneCeiling;
import com.fy.codeDesign.demo09.matter.ceiling.LevelTwoCeiling;
import com.fy.codeDesign.demo09.matter.coat.DuluxCoat;
import com.fy.codeDesign.demo09.matter.coat.LiBangCoat;
import com.fy.codeDesign.demo09.matter.floor.ShengxiangFloor;
import com.fy.codeDesign.demo09.matter.tile.DongPengTile;
import com.fy.codeDesign.demo09.matter.tile.MarcoPoloTile;

import java.math.BigDecimal;

/**
 * @description:
 * @author：AhHao
 * @date: 2022/3/29
 */
public class Builder {

    public IMenu levelOne(BigDecimal area){
        return new DecorationPackageMenu(area,"豪华欧式")
                .appendCeiling(new LevelTwoCeiling())
                .appendCoat(new DuluxCoat())
                .appendFloor(new ShengxiangFloor());
    }

    public IMenu levelTwo(BigDecimal area){
        return new DecorationPackageMenu(area,"轻奢田园")
                .appendCeiling(new LevelTwoCeiling())
                .appendCoat(new LiBangCoat())
                .appendTile(new MarcoPoloTile());
    }


    public IMenu levelThree(BigDecimal area){
        return new DecorationPackageMenu(area,"现代简约")
                .appendCeiling(new LevelOneCeiling())
                .appendCoat(new LiBangCoat())
                .appendTile(new DongPengTile());
    }
}
