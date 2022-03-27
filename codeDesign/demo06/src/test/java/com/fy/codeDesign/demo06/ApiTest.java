package com.fy.codeDesign.demo06;

import com.fy.codeDesign.demo06.optimization.DrawCtl;
import com.fy.codeDesign.demo06.optimization.DrawRandom;
import com.fy.codeDesign.demo06.optimization.DrawWeight;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author：AhHao
 * @date: 2022/3/27
 */
public class ApiTest {

    public static void main(String[] args) {

        ArrayList<BetUser> users = new ArrayList<>();
        users.add(new BetUser("张三",10));
        users.add(new BetUser("王五",3));
        users.add(new BetUser("赵六",8));
        users.add(new BetUser("小七",7));
        users.add(new BetUser("小八",5));

        System.out.println("----------------------非依赖倒置原则--------------------------");
        DrawControl drawControl = new DrawControl();
        List<BetUser> betUsers = drawControl.doDrawRandom(users, 3);
        System.out.println("随机抽奖结果：" + betUsers.toString());
        List<BetUser> betUsers1 = drawControl.doDrawWeight(users, 3);
        System.out.println("权重抽奖结果：" + betUsers1.toString());

        System.out.println("----------------------依赖倒置原则--------------------------");
        DrawCtl drawCtl = new DrawCtl();
        List<BetUser> betUsers2 = drawCtl.doDraw(new DrawRandom(), users, 3);
        System.out.println("随机抽奖结果：" + betUsers2.toString());
        List<BetUser> betUsers3 = drawCtl.doDraw(new DrawWeight(), users, 3);
        System.out.println("权重抽奖结果：" + betUsers3.toString());
    }


}
