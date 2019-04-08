package com.itheima.job01;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.SimpleTimeZone;

public class job01 {
    public static void main(String[] args) {
        char[] chars = {'i','t','c','a','s','a'};
        System.arraycopy(chars,1,chars,5,1);
        System.out.println(Arrays.toString(chars));
    }


    // 字符串翻转找对称
    public static void strReverse(){
        String[] str={"010","3223","666","7890987","123123"};
        for (int i = 0; i < str.length; i++) {
            StringBuilder strs = new StringBuilder(str[i]);
            if(String.valueOf(strs.reverse()).equals(str[i])){
                System.out.println(str[i]);
            }
        }
    }

    public static void strChar(){
        String str = "abcd";
        char[] chars = new char[15];
        char[] chasr1= str.toCharArray();
        for (int x = 1; x <= chars.length; x++) {
            if(x%chasr1.length==0){
                System.arraycopy(chasr1,0,chars,(x-chasr1.length),chasr1.length);
            }else if(chars.length%chasr1.length==x){
                System.arraycopy(chasr1,0,chars,(chars.length-x),x);
            }
        }
        System.out.println(Arrays.toString(chars));
    }

}
