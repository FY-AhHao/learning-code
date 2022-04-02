package com.fy.codeDesign.demo10.prototypeMode;

import java.util.Map;

/**
 * @description: 选项和答案
 * @author：AhHao
 * @date: 2022/4/2
 */
public class Answer {

    private Map<String,String> option;
    private String answer;

    public Answer(Map<String, String> option, String answer) {
        this.option = option;
        this.answer = answer;
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
