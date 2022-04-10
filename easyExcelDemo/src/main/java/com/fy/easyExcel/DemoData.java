package com.fy.easyExcel;

import com.alibaba.excel.annotation.ExcelProperty;

import java.util.Date;

/**
 * @description: 测试数据
 * @author：AhHao
 * @date: 2022/4/10
 */
public class DemoData {

    @ExcelProperty("用户名")
    private String name;

    @ExcelProperty("年龄")
    private Integer age;

    @ExcelProperty("生日")
    private Date birthday;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
