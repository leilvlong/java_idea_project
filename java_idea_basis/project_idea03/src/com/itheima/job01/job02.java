package com.itheima.job01;

import java.lang.reflect.Array;
import java.util.Arrays;

public class job02 {
    public static void main(String[] args) {
        String str = "abcd";
        char[] chars = new char[15];
        char[]strCha = str.toCharArray();
        for (int x = 1; x <= chars.length; x++) {
            if(x%strCha.length==0){
                System.arraycopy(strCha,0,chars,x-strCha.length,strCha.length);
            }else if(chars.length%strCha.length==x){
                System.arraycopy(strCha,0,chars,chars.length-x,x);
            }
        }
        System.out.println(Arrays.toString(chars));
    }


}
