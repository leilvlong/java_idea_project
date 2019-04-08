package com.itheima.job04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/*
Comparator.sort
    自定义排序规则:
        参数 <E> o1  <E> o2
        逻辑处理:
            类似二叉树原理
            o2的第一个元素为有索引容器的第0个元素
            o1 与 o2的计算值(比较) 若返回正数 则将  o1置于 o2 的右边
                o2会随着计算比较的变化呈现树形比较变化
            o1 与 o2的计算值(比较) 若返回负数 则将  o1置于 o2 的左边
                o2会随着计算比较的变化呈现树形比较变化
            o2 为二叉树上以确定的元素

涉及到使用比较进行排序时:
    不要钻牛角尖
     if o2>o1  返回正数  则降序  == if o1>o2 返回负数 则降序
     if o2>o1  返回负数  则升序  == if o1>o2 返回正数 则升序
  */
public class job20 {
    public static void main(String[] args) {
        //fun();
        fun2();
    }

    public static void fun(){
        ArrayList<Integer> ints =new ArrayList<>();
        ints.add(12);
        ints.add(7);
        ints.add(15);
        ints.add(9);
        ints.add(18);
        ints.add(6);
        System.out.println(ints);
        // 升序排序
        //Collections.sort(ints,(Integer o1,Integer o2)->{ return o1-o2;});
        // 降序排序
        Collections.sort(ints,(Integer o1,Integer o2)->{ return o2-o1;});
        System.out.println(ints);
    }

    public static void fun2(){
        ArrayList<Studen> stus = new ArrayList<>();
        stus.add(new Studen("一",18,98));
        stus.add(new Studen("二",19,99));
        stus.add(new Studen("三",20,98));
        stus.add(new Studen("四",20,98));
        stus.add(new Studen("五",18,100));
        // 学生按成绩降序排名 如果成绩相同 则按年龄升序排名
        Collections.sort(stus,(Studen o1,Studen o2)->{
            if(o1.sc>o2.sc){
                return 1;
            }else if(o1.sc<o2.sc){
                return -1;
            }else{
                if(o2.age>o1.age){
                    return -1;
                }else if(o2.age<o1.age){
                    return 1;
                }else{
                    return 0;
                }
            }
        });
        for (Studen studen : stus) {
            System.out.println(studen);
        }
    }

}

class Studen{
    String name;
    int age;
    float sc;

    public Studen(String name, int age, float sc) {
        this.name = name;
        this.age = age;
        this.sc = sc;
    }

    @Override
    public String toString() {
        return "Studen{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sc=" + sc +
                '}';
    }
}
