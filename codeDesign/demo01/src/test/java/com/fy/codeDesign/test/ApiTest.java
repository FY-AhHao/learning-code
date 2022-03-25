package com.fy.codeDesign.test;

import com.fy.codeDesign.demo01.VideoUserService;
import com.fy.codeDesign.optimization.GuestVideUserService;
import com.fy.codeDesign.optimization.IVideUserService;
import com.fy.codeDesign.optimization.NormalUserVideUserService;
import com.fy.codeDesign.optimization.VipUserVideUserService;

/**
 * @description:
 * @author：AhHao
 * @date: 2022/3/25
 */
public class ApiTest {

    public static void main(String[] args) {

        System.out.println("-----------------------非单一职责--------------------------");
        //非单一职责
        VideoUserService videoUserService = new VideoUserService();
        videoUserService.serveGrade("guest");
        videoUserService.serveGrade("normalUser");
        videoUserService.serveGrade("vipUser");

        System.out.println("-----------------------单一职责--------------------------");

        //单一职责
        IVideUserService guestService = new GuestVideUserService();
        guestService.definition();
        guestService.advertisement();
        IVideUserService normalUserService = new NormalUserVideUserService();
        normalUserService.definition();
        normalUserService.advertisement();
        IVideUserService vipUserService = new VipUserVideUserService();
        vipUserService.definition();
        vipUserService.advertisement();
    }
}
