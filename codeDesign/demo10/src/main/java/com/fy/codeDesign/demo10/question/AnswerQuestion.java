package com.fy.codeDesign.demo10.question;

/**
 * @description: 问答题
 * @author：AhHao
 * @date: 2022/4/2
 */
public class AnswerQuestion {

    private String name;
    private String answer;

    public AnswerQuestion(String name, String answer) {
        this.name = name;
        this.answer = answer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
