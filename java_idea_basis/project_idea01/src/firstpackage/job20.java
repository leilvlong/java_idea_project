package firstpackage;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
Comparator.sort
    自定义排序规则:
        参数 <E> o1  <E> o2
        逻辑处理:
            以o1做被操作数 o2做操作数 其操作结果返回值若为:
                正: o1在右 o2在左 交换位置  (即升序)
                负; 所处位置不变
            以o2做被操作数 o1做操作数 其操作结果返回值若为:
                正: 所处位置不变
                负: o2在左 o1在右 交换位置  (即降序)
        以冒泡排序为例:
            会将原容器中的每个元素与子容器中的每个元素遍历比较确定其所在原容器的位置
            冒泡排序表达式:
                int[] ints = {3,5};
                for (int i = 0; i < ints.length; i++) {
                    for (int y = 0; y < i; y++) {
                        if(ints[i]>ints[y]){
                            int anInt = ints[i];
                            ints[i] = ints[y];
                            ints[y]=anInt;
                        }
                    }
                }
                System.out.println(Arrays.toString(ints));
            该计算公式中o1 o2 各自为:
                o1: ints[i]
                o2: ints[y]




  */
public class job20 {
    public static void main(String[] args) {
        //fun();
        //fun2();

        int[] ints = {3,5};
        for (int i = 0; i < ints.length; i++) {
            for (int y = 0; y < i; y++) {
                if(ints[i]>ints[y]){
                    int anInt = ints[i];
                    ints[i] = ints[y];
                    ints[y]=anInt;
                }
            }
        }
        System.out.println(Arrays.toString(ints));


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
