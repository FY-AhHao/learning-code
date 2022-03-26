package com.fy.codeDesign.demo04;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 校长类
 * @author：AhHao
 * @date: 2022/3/26
 */
public class Principal {

    private Teacher teacher = new Teacher("张老师","1A班");

    public Map<String,Object> getClassInfo(){
        int studentCount = teacher.studentCount();
        int totalGrade = teacher.totalGrade();
        int avgGrade = teacher.avgGrade();
        Map<String,Object> map = new HashMap<>();
        map.put("班级",teacher.getClassCode());
        map.put("老师",teacher.getName());
        map.put("总人数",studentCount);
        map.put("总分",totalGrade);
        map.put("平均分",avgGrade);
        return map;
    }
}
