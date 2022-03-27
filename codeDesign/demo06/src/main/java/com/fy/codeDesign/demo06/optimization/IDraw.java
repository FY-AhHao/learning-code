package com.fy.codeDesign.demo06.optimization;

import com.fy.codeDesign.demo06.BetUser;

import java.util.List;

/**
 * @description: 抽奖接口
 * @author：AhHao
 * @date: 2022/3/27
 */
public interface IDraw {

    List<BetUser> doDraw(List<BetUser> users,int count);
}
