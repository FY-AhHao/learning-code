package com.fy.easyExcel.test;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.fy.easyExcel.DemoData;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @description: 测试类
 *  easyExcel官网 https://www.yuque.com/easyexcel/doc/write#afb7324a
 * @author：AhHao
 * @date: 2022/4/10
 */
public class ApiTest {

    /**
     * 模拟从数据库查询数据
     * @return
     */
    private List<DemoData> data(){
        List<DemoData> dataList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            DemoData demoData = new DemoData();
            demoData.setName("user" + i);
            demoData.setAge(random.nextInt(30));
            Date date = new Date();
            demoData.setBirthday(date);
            dataList.add(demoData);
        }
        return dataList;
    }

    /**
     * 测试重复写（大量数据时使用）
     */
    @Test
    public void repeatedWrite() {
        String fileName = ApiTest.class.getResource("/").getPath() + "repeatedWrite" + System.currentTimeMillis() + ".xlsx";
        ExcelWriter excelWriter = null;
        try {
            //指定写excel对应的类
            excelWriter = EasyExcel.write(fileName, DemoData.class).useDefaultStyle(false).build();
            //指定写到哪个sheet
            WriteSheet writeSheet = EasyExcel.writerSheet("用户列表").build();
            //模拟从数据库查出数据,重复写入5次，实际开发时，可以是分页查询数据
            for (int i = 0; i < 5; i++) {
                //分页查询每页的数据
                List<DemoData> data = data();
                //写入到excel
                excelWriter.write(data,writeSheet);
            }
        } finally {
            if (excelWriter != null) {
                excelWriter.finish();
            }
        }
    }
}
