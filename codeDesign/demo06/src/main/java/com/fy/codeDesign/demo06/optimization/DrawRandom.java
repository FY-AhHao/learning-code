package com.fy.codeDesign.demo06.optimization;

import com.fy.codeDesign.demo06.BetUser;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description: 随机抽奖
 * @author：AhHao
 * @date: 2022/3/27
 */
public class DrawRandom implements IDraw{

    @Override
    public List<BetUser> doDraw(List<BetUser> users, int count) {
        if (users.size() < count) {
            return users;
        }
        //乱序
        Collections.shuffle(users);
        return users.stream().limit(count).collect(Collectors.toList());
    }
}
