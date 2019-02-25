package firstpackage;

import java.util.Scanner;

public class Job01 {
    public static void main(String[] args) {
        // 正直角三角形
        //triangle1();

        // 反直角三角形
        //triangle2();

        //输出倒正直角三角形
        //triangle3();

        //输出倒反直角三角形
        //triangle4();

        // 输出等腰三角形
        triangle5();
    }

    public static void primeNumber() {
        /*
            求素数的两个关键条件
            1.不被别的数整除
            2.只能被自身与1整除
         */
        // 计数君
        int a = 1;
        // 每个原始数被用来判断是否可以被整除与是否只能被自身整除
        for (int i = 2; i < 100; i++) {
            // 原始数之前的每个数 用来做是否能被整除
            for (int y = 2; y <= i; y++) {
                // 如果被整除了 且不等自身  就非素数 没必要再循环
                if (i % y == 0 && y != i) {
                    break;
                }
                //  获得素数的另一个关键条件
                if (i % y == 0 && y == i) {
                    System.out.print(i + " ");
                    //计数君的打印输出
                    if (a % 5 == 0) {
                        System.out.println();
                    }
                    a++;
                }
            }
        }
    }

    public static void whileprime() {
        /*
            求素数的两个关键条件
            1.不被别的数整除
            2.只能被自身与1整除
         */
        int i = 2;
        int x = 1;
        while (i < 101) {
            int y = 2;
            while (y <= i) {
                if (i % y == 0 && i != y) {
                    break;
                }
                if (i % y == 0 && i == y) {
                    System.out.print(i + "  ");
                    if (x % 5 == 0) {
                        System.out.println();
                    }
                    x++;
                }
                y++;
            }
            i++;
        }
    }

    public static void triangle1() {
        /*
            正直角三角形
            1. 控制输出行
            2.控制星星数
            3.输出换行
        */
        for (int i=1; i<5; i++) {
            for (int y=1; y <= i; y++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void triangle2(){
        /*
            反直角三角形
            1. 控制输出行
            2. 控制输出空格
                第一行输出的空格应该为 x-y但是最少要输出一颗星星
            3. 控制输出星星
         */
        for(int x=5; x>1; x--){
            for(int y=1; y<5;y++){
                if(x-y>1){
                    System.out.print(" ");
                }else{
                    System.out.print("*");
                }

            }
            System.out.println();
        }
    }

    public static void triangle3(){
        /*
            输出倒正直角三角形
            1.控制输出行
            2.控制输出星星
         */
        for (int x=5; x>=1; x--){
            for(int y=1;y<x; y++) {
                System.out.print("*");
                }
            System.out.println();
            }
    }

    public static void triangle4(){
        /*
            输出倒反直角三角形
            1.控制输出行
            2.控制输出空格
                内循环的y - 外循环的x的到当前应该输出的空格数量 剩下额都输出*
         */
        for(int x=5; x>1; x--){
            for(int y=5; y>1; y--){
                if (y-x>=1){
                    System.out.print(" ");
                }else {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }

    public static void triangle5(){
        /*
            输出等腰三角形
            1. 控制输出行
            2.控制输出空格
            3 .控制输出*
         */
        for (int x=1; x<5; x++){
            for(int y=5;y>x; y-- ){
                System.out.print(" ");
            }
            for(int z=1; z<x*2; z++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void strui(){
        System.out.print("在idea 中 push我的文件");
    }
}


