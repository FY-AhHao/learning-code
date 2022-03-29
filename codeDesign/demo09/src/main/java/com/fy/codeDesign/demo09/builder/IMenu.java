package com.fy.codeDesign.demo09.builder;

import com.fy.codeDesign.demo09.matter.Matter;

/**
 * @description:
 * @author：AhHao
 * @date: 2022/3/29
 */
public interface IMenu {

    IMenu appendCeiling(Matter matter);

    IMenu appendCoat(Matter matter);

    IMenu appendFloor(Matter matter);

    IMenu appendTile(Matter matter);

    String getDetail();
}
