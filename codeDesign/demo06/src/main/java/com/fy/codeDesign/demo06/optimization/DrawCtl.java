package com.fy.codeDesign.demo06.optimization;

import com.fy.codeDesign.demo06.BetUser;

import java.util.List;

/**
 * @description: 抽奖控制类
 * @author：AhHao
 * @date: 2022/3/27
 */
public class DrawCtl {

    public List<BetUser> doDraw(IDraw draw,List<BetUser> users,int count) {
        return draw.doDraw(users,count);
    }
}
