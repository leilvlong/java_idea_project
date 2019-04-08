package com.itheima.job04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class job04 {
    public static void main(String[] args) {
        charArray();
    }

    public static void charArray(){
        ArrayList<String> strList = new ArrayList<>();
        strList.add("adf");
        strList.add("adf");
        strList.add("adf");
        strList.add("feg");

        //
        HashMap<Character,Integer> charCount = new HashMap<>();
        for (String str : strList) {
            char[] chars = str.toCharArray();
            for (int x = 0; x < chars.length; x++) {
                if(charCount.containsKey(chars[x])){
                    charCount.put(chars[x],charCount.get(chars[x])+1);
                }else{
                    charCount.put(chars[x],1);
                }
            }
        }

        for (Character cha : charCount.keySet()) {
            System.out.println(cha+": "+charCount.get(cha));
        }
    }
}


