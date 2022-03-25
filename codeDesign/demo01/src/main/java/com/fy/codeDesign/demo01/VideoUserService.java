package com.fy.codeDesign.demo01;

/**
 * @description: 视频用户服务
 * @author：AhHao
 * @date: 2022/3/25
 */
public class VideoUserService {

    public void serveGrade(String userType){
        if ("guest".equals(userType)){
            System.out.println("访客，视频分辨率480P");
        } else if ("normalUser".equals(userType)){
            System.out.println("普通用户，视频分辨率720P");
        }else if ("vipUser".equals(userType)){
            System.out.println("vip用户，视频分辨率1080P");
        }
    }
}
