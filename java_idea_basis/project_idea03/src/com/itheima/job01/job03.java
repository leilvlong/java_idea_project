package com.itheima.job01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class job03 {
    public static void main(String[] args) throws ParseException {
//        使用SimpleDateFormat类,把2018-03-04转换为2018年03月04日
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        sdf.applyLocalizedPattern("yyyy/MM/dd");

        Date date = sdf.parse("2018-2-14");

        SimpleDateFormat sdf2 = new SimpleDateFormat("E");

        System.out.println(sdf2.format(date));

    }
}
