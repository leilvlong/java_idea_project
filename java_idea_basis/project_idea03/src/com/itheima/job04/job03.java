package com.itheima.job04;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class job03 {
    public static void main(String[] args) {
        HashMap<Integer,String> hashMap = new HashMap<>();
        hashMap.put(1,"一");
        hashMap.put(2,"二");
        hashMap.put(3,"三");
        Set<Integer> integers = hashMap.keySet();
        /*for (Integer integer : integers) {
            System.out.println(hashMap.get(integer));
        }*/

        Set<Map.Entry<Integer, String>> entries = hashMap.entrySet();
        for (Map.Entry<Integer, String> entry : entries) {
            Integer key = entry.getKey();

            entry.setValue("haha");
            
            System.out.println(entry);
        }
        System.out.println(hashMap);
    }
}
