package com.fy.codeDesign.demo10.prototypeMode;

import java.util.*;

/**
 * @description: 选项乱序工具类
 * @author：AhHao
 * @date: 2022/4/2
 */
public class AnswerRandomUtil {

    public static Answer random(Map<String,String> options, String answer){

        Set<String> optionKeys = options.keySet();
        //选项乱序
        ArrayList<String> optionKeyList = new ArrayList<>(optionKeys);
        Collections.shuffle(optionKeyList);

        HashMap<String, String> newOptions = new HashMap<>();
        //乱序后的正确答案选项
        String newAnswer = "";
        int idx = 0;
        for (String optionKey : optionKeys) {
            String randomKey = optionKeyList.get(idx++);
            newOptions.put(randomKey,options.get(optionKey));

            if (answer.equals(optionKey)){
                newAnswer = randomKey;
            }
        }

        return new Answer(newOptions,newAnswer);
    }

}
