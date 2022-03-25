package com.fy.codeDesign.optimization;

/**
 * @description: 普通用户视频服务
 * @author：AhHao
 * @date: 2022/3/25
 */
public class NormalUserVideUserService implements IVideUserService {
    public void definition() {
        System.out.println("普通用户，视频分辨率720P");
    }

    public void advertisement() {
        System.out.println("普通用户，投放30秒广告");
    }
}
