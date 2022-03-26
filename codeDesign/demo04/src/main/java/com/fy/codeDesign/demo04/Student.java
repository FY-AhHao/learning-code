package com.fy.codeDesign.demo04;

/**
 * @description: 学生类
 * @author：AhHao
 * @date: 2022/3/26
 */
public class Student {

    private String name;
    private int rank;
    private int grade;

    public Student() {
    }

    public Student(String name, int rank, int grade) {
        this.name = name;
        this.rank = rank;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
