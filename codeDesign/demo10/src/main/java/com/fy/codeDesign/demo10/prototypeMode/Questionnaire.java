package com.fy.codeDesign.demo10.prototypeMode;

import com.fy.codeDesign.demo10.question.AnswerQuestion;
import com.fy.codeDesign.demo10.question.ChoiceQuestion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

/**
 * @description: 试题
 * @author：AhHao
 * @date: 2022/4/2
 */
public class Questionnaire implements Cloneable{

    private String candidate;
    private String number;
    private ArrayList<ChoiceQuestion> choiceQuestions = new ArrayList<>();
    private ArrayList<AnswerQuestion> answerQuestions = new ArrayList<>();

    public String getCandidate() {
        return candidate;
    }

    public void setCandidate(String candidate) {
        this.candidate = candidate;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Questionnaire append(ChoiceQuestion choiceQuestion){
        choiceQuestions.add(choiceQuestion);
        return this;
    }

    public Questionnaire append(AnswerQuestion answerQuestion){
        answerQuestions.add(answerQuestion);
        return this;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Questionnaire questionnaire = (Questionnaire) super.clone();
        questionnaire.choiceQuestions = (ArrayList<ChoiceQuestion>) choiceQuestions.clone();
        questionnaire.answerQuestions = (ArrayList<AnswerQuestion>) answerQuestions.clone();

        //题目乱序
        Collections.shuffle(questionnaire.choiceQuestions);
        Collections.shuffle(questionnaire.answerQuestions);

        //答案乱序
        for (ChoiceQuestion choiceQuestion : questionnaire.choiceQuestions) {
            Answer random = AnswerRandomUtil.random(choiceQuestion.getOption(), choiceQuestion.getAnswer());
            choiceQuestion.setOption(random.getOption());
            choiceQuestion.setAnswer(random.getAnswer());
        }

        return questionnaire;
    }

    @Override
    public String toString() {
        StringBuilder detail = new StringBuilder("考生：" + candidate + "\r\n" +
                "考号：" + number + "\r\n" +
                "--------------------------------------------\r\n" +
                "一、选择题" + "\r\n\n");

        for (int idx = 0; idx < choiceQuestions.size(); idx++) {
            detail.append("第").append(idx + 1).append("题：").append(choiceQuestions.get(idx).getName()).append("\r\n");
            Map<String, String> option = choiceQuestions.get(idx).getOption();
            for (String key : option.keySet()) {
                detail.append(key).append("：").append(option.get(key)).append("\r\n");;
            }
            detail.append("答案：").append(choiceQuestions.get(idx).getAnswer()).append("\r\n\n");
        }

        detail.append("二、问答题" + "\r\n\n");

        for (int idx = 0; idx < answerQuestions.size(); idx++) {
            detail.append("第").append(idx + 1).append("题：").append(answerQuestions.get(idx).getName()).append("\r\n");
            detail.append("答案：").append(answerQuestions.get(idx).getAnswer()).append("\r\n\n");
        }

        return detail.toString();
    }
}
