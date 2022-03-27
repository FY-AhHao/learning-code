package com.fy.codeDesign.demo06.optimization;

import com.fy.codeDesign.demo06.BetUser;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description: 权重抽奖
 * @author：AhHao
 * @date: 2022/3/27
 */
public class DrawWeight implements IDraw{

    @Override
    public List<BetUser> doDraw(List<BetUser> users, int count) {
        if (users.size() < count) {
            return users;
        }

        List<BetUser> sortUsers = users.stream().sorted((o1, o2) -> {
            int e = o1.getWeight() - o2.getWeight();
            if (e == 0) {
                return 0;
            }
            return e > 0 ? -1 : 1;
        }).collect(Collectors.toList());


        return sortUsers.stream().limit(count).collect(Collectors.toList());
    }
}
