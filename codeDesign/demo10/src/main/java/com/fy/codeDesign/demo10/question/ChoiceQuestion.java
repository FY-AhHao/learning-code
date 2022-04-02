package com.fy.codeDesign.demo10.question;

import java.util.Map;

/**
 * @description: 选择题
 * @author：AhHao
 * @date: 2022/4/2
 */
public class ChoiceQuestion {

    private String name;
    private Map<String,String> option;
    private String answer;

    public ChoiceQuestion(String name, Map<String, String> option, String answer) {
        this.name = name;
        this.option = option;
        this.answer = answer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, String> getOption() {
        return option;
    }

    public void setOption(Map<String, String> option) {
        this.option = option;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
