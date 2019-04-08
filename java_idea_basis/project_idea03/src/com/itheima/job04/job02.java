package com.itheima.job04;

import java.util.ArrayList;

public class job02 {
    public static void main(String[] args) {
         // 求2进制 除2取余
        ArrayList<Integer> ints = new ArrayList<>();
        int num = 97;
        int two;
        while(true){
            if(num==0){
                break;
            }
            two = num%2;
            num = num/2;
            ints.add(two);
        }
        System.out.println(ints);
    }
}
