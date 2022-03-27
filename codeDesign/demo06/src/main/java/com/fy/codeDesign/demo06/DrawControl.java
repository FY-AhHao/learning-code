package com.fy.codeDesign.demo06;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description: 抽奖控制类
 * @author：AhHao
 * @date: 2022/3/27
 */
public class DrawControl {

    //随机抽奖
    public List<BetUser> doDrawRandom(List<BetUser> users, int count) {
        if (users.size() < count) {
            return users;
        }
        //乱序
        Collections.shuffle(users);
        return users.stream().limit(count).collect(Collectors.toList());
    }

    //权重抽奖
    public List<BetUser> doDrawWeight(List<BetUser> users, int count) {
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
