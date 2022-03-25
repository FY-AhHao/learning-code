package com.fy.codeDesign.optimization;

/**
 * @description: vip用户视频服务
 * @author：AhHao
 * @date: 2022/3/25
 */
public class VipUserVideUserService implements IVideUserService {
    public void definition() {
        System.out.println("vip用户，视频分辨率1080P");
    }

    public void advertisement() {
        System.out.println("vip用户，没有广告");
    }
}
