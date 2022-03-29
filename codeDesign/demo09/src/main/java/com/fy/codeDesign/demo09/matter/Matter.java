package com.fy.codeDesign.demo09.matter;

import java.math.BigDecimal;

/**
 * @description: 装修物料
 * @author：AhHao
 * @date: 2022/3/29
 */
public interface Matter {

    //地板、地砖、涂料、吊顶
    String scene();

    //品牌
    String brand();

    //型号
    String model();

    //平米报价
    BigDecimal price();

    //描述
    String desc();
}
