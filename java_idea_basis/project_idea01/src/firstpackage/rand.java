package firstpackage;

import jdk.swing.interop.SwingInterOpUtils;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class rand {
    public static void main(String[] args) {
        int[] str = new int[10];
        for (int x:str) {
            System.out.println(x);
        }

    }

    public static void rand1(double num1, int part){
        // 随机数对象
        Random rand = new Random();
        //随机数列表
        ArrayList<Double> list = new ArrayList<>();
        // 获取两位随机数的对象的格式化方法
        DecimalFormat dec = new DecimalFormat("#0.00");

        // 随机获取的double(最大值为1 防止num1不够分) * (mum1/part)
        int num2 = (int)(num1/part);
        for(int x=1; x<=part; x++){
            if(x==part){
                num1 = Double.parseDouble(dec.format(num1));
                list.add(num1);
                break;
            }
            // 获取两位随机数
            double num3 = Double.parseDouble((dec.format(rand.nextDouble())));
            // 防止0.0的尴尬现象
            num3+=0.1;
            //最大值为0.99
            if(num3>1){
                num3 = num3-((num3-1)+0.01);
            }
            //转成整数  因为依然会有损失精确度的现象
            num3 = Double.parseDouble(dec.format(num3*100));
            // 再次转换成两位小数 解决精度问题
            num3 = num3/100;
            // 随机数公式
            double num4 = num3*num2;
            num4 = Double.parseDouble(dec.format(num4));
            num1 -=num4;
            list.add(num4);
        }
        System.out.println(list.toString());
    }
}
