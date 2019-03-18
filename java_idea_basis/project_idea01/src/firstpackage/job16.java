package firstpackage;

import java.util.ArrayList;

/*
lambda 表达式示例
虽然不那么面向,且使用起来诸多限制:
    如接口只能有一个抽象方法
但是比较优雅:
    ()->就可以代替整个匿名内部类

使用lambda的场景:
    抽象类或者接口只有一个方法,而方法的参数中 为该抽象类(接口)的实现子类参数 即可使用
    例1:
        arrays.removeif() 的参数为:  Predicate<? super E> filter:
            - <? extends E>:固定泛型的上边界, 泛型可以是E, 也可以是E的子类
            - <? super E>: 固定泛型的下边界, 泛型可以是E, 也可以是E的父类
        在该方法中 传入一个lambda表达式 java会将其视为该接口的实现方法
    例2:
        开启线程时:
        new Thread(()->{
           for (int x = 0; x < 100; x++) {
               System.out.println("AAAAAAAAAAAAAAAAAAAA");
           }
       }).start();
        new Thread(()->{
            for (int x = 0; x < 100; x++) {
                System.out.println("111111111111111111111");
            }
        }).start();
 */
public class job16 {
    public static void main(String[] args) {
        /*int[] ints = {1,2,3,4};
        System.out.println("lambda表达式________________________");
        int sum1 = fun1(ints,ints1 ->{
            int sum=0;
            for (int i : ints1) {
                sum+=i;
            }
            return sum;
        } );
        System.out.println(sum1);
        System.out.println();

        System.out.println("接口的内部类实现抽象方法________________");
        int sum2 = fun2(ints);
        System.out.println(sum2);
        System.out.println();

        System.out.println("匿名内部类_________________");
        int sum3 = fun3(ints, new Interf() {
            @Override
            public int sumArrar(int[] ints) {
                int sum = 0;
                for (int anInt : ints) {
                    sum+=anInt;
                }
                return sum;
            }
        });
        System.out.println(sum3);*/

       /* ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.removeIf((num)->{
            return num>3;
        });
        System.out.println(arr);*/

       new Thread(()->{
           for (int x = 0; x < 100; x++) {
               System.out.println("AAAAAAAAAAAAAAAAAAAA");
           }
       }).start();
        new Thread(()->{
            for (int x = 0; x < 100; x++) {
                System.out.println("111111111111111111111");
            }
        }).start();

    }

    public static int fun1(int[] ints,Interf interf){
        return interf.sumArrar(ints);
    }

    public static int fun2(int[] ints){
        Interf.Sum sum=new Interf.Sum();
        return sum.sumArrar(ints);
    }

    public static int fun3(int[] ints, Interf interf){
        return interf.sumArrar(ints);

    }
}

interface Interf{
    int sumArrar(int[] ints);

    class Sum implements Interf{

        @Override
        public int sumArrar(int[] ints) {
            int sum = 0;
            for (int anInt : ints) {
                sum+=anInt;
            }
            return sum;
        }
    }
}