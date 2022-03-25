package com.fy.codeDesign.optimization;

/**
 * @description: 访客视频服务
 * @author：AhHao
 * @date: 2022/3/25
 */
public class GuestVideUserService implements IVideUserService {
    public void definition() {
        System.out.println("访客，视频分辨率480P");
    }

    public void advertisement() {
        System.out.println("访客，投放90秒广告");
    }
}
