package firstpackage;

import java.util.Scanner;

/*
运用目前所接触的java知识
运用面向对象的思维开发简单的计算器功能

 */
public class job03 {
    public static void main(String[] args) {
        GetInput getinput = new GetInput();
        getinput.runOperation();
    }
}

class GetInput{
    // 在这里获取输入 并处理用户运算
    public static void runOperation() {
        RunOperation rop = new RunOperation();
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入运算: \n");
        if (sc.hasNextInt()) {
            int num1 = sc.nextInt();
            String oper =rop.userInputOperator();
            int num2 = sc.nextInt();
            rop.operation(oper,num1,num2);
        } else if (sc.hasNextDouble()) {
            double num1 = sc.nextDouble();
            String oper = rop.userInputOperator();
            double num2 = sc.nextDouble();
            rop.operation(oper,num1,num2);
        } else {
            System.out.println("输入非法");
        }
    }


}


class RunOperation {
    /*
    运算类 在这里对获取的数据进行简单的运算
     */

    public static String userInputOperator(){
        // 获取运算符
        Scanner sc = new Scanner(System.in);
        String operator = sc.next();
        return operator;
    }

    public static void operation( String opera,int num1, int num2){
        Calculate cal = new Calculate();
        switch(opera){
            case "+":
                System.out.println(cal.add(num1,num2));
                break;
            case "-":
                System.out.println(cal.reduce(num1,num2));
                break;
            case "*":
                System.out.println(cal.mulptily(num1,num2));
                break;
            case "/":
                System.out.println(cal.divide(num1,num2));
                break;
            default:
                System.out.println("运算符输入有误,只允许 + - * /");
        }
    }

    public static void operation(String oper,double num1,double num2){
        Calculate cal = new Calculate();
        switch(oper){
            case "+":
                System.out.println(cal.add(num1,num2));
                break;
            case "-":
                System.out.println(cal.reduce(num1,num2));
                break;
            case "*":
                System.out.println(cal.mulptily(num1,num2));
            case "/":
                System.out.println(cal.divide(num1,num2));
                break;
            default:
                System.out.println("运算符输入有误,只允许 + - * /");
        }
    }
}


class Calculate{

    /*
      数据运算工具类
      目前仅支持简单的两数运算
    */
    public static int add(int num1, int num2) {
        // 整数相加
        return num1 + num2;
    }

    public static double add(double num1, double num2) {

        return num1 + num2;
    }

    public static int reduce(int num1, int num2) {
        return num1 - num2;
    }

    public static double reduce(double num1, double num2) {
        return num1 - num2;
    }

    public static int mulptily(int num1, int num2) {
        return num1 * num2;
    }

    public static double mulptily(double num1, double num2) {
        return num1 * num2;
    }

    public static int divide(int num1, int num2) {
        return num1 / num2;
    }

    public static double divide(double num1, double num2) {
        return num1 / num2;
    }
}