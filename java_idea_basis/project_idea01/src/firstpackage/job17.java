package firstpackage;

/*
set的简单使用
与List的有序(存取有序) 有索引  可重复不同
Set 无序 无索引 不可重复
使用这种数据结构目前想到的使用场景为:
    1. 确保数据唯一
    2. 去重

 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class job17 {
    public static void main(String[] args) {
        // 转set 去重
        hashSet();
    }

    public static void hashSet(){
        ArrayList<String> strs = new ArrayList<>();
        strs.add("a");
        strs.add("a");
        strs.add("b");
        strs.add("b");
        strs.add("c");
        strs.add("c");

        // 转set去重
        //strs = new ArrayList<>(new HashSet<>(strs));
        //strs = new ArrayList<>(new LinkedHashSet<>(strs));
        //strs = new ArrayList<>(new TreeSet<>(strs));
        System.out.println(strs);


    }

}
