package com.fy.codeDesign.demo04;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 老师类
 * @author：AhHao
 * @date: 2022/3/26
 */
public class Teacher {

    private String name;
    private String classCode;
    private List<Student> studentList = new ArrayList<>();

    public Teacher() {
        init();
    }

    public Teacher(String name, String classCode) {
        this.name = name;
        this.classCode = classCode;
        init();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }

    private void init(){
        studentList.add(new Student("张三",3,530));
        studentList.add(new Student("李四",1,570));
        studentList.add(new Student("王五",4,510));
        studentList.add(new Student("赵六",2,550));
    }

    public int studentCount(){
        return studentList.size();
    }

    public int avgGrade(){
        return totalGrade() / studentCount();
    }

    public int totalGrade(){
        return studentList.stream().map(Student::getGrade).reduce(Integer::sum).orElse(0);
    }

}
