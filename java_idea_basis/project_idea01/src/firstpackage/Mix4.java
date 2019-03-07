package firstpackage;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;


/**
 * BigDecimal  处理double防止精度丢失很好用
 */
public class Mix4{
    public static void main(String[] args) {
        /*
        // double + 运算  根据精度要求自行选择    减与乘 参数规则同+一致(参数列表,保留精度)
        double num1 = 10.231;
        double num2 = 10.21;
        double num3 = 11.134;
        int num4 = 100;
        BigDecimal big1 = new BigDecimal(num1);
        BigDecimal big2 = new BigDecimal(num2);
        BigDecimal big3 = new BigDecimal(num3);
        BigDecimal big4 = new BigDecimal(num4);
        System.out.println(big3.add(big1.add(big2,MathContext.DECIMAL32),MathContext.DECIMAL32));
//        System.out.println(big3.add(big1.add(big2,MathContext.DECIMAL64),MathContext.DECIMAL64));
//        System.out.println(big3.add(big1.add(big2,MathContext.DECIMAL128),MathContext.DECIMAL128));
//        System.out.println(big3.add(big1.add(big2,MathContext.UNLIMITED),MathContext.UNLIMITED));
        */

        /*
        double /  运算
        double num1 = 11.34;
        double num2 = 13.76;
        BigDecimal big1 = new BigDecimal(num1);
        BigDecimal big2 = new BigDecimal(num2);
        System.out.println(big1.divide(big2,3,RoundingMode.HALF_UP));
        //  BigDecimal.divide(参数1: 被除 big对象, 参数2:  保留小数位,  参数3  保留规则)
        //  RoundingMode.HALF_UP 四舍五入
        //  RoundingMode.HALF_DOWN  非四舍五入
        */


        //BigDecimal.setScale(参数1: 保留位数 , 参数2: 保留规则)
        //  RoundingMode.UP 舍弃时最后一位+1 注意尾数为9时 最后一位变0 倒数第二位+1
        //  RoundingMode.DOWN 舍弃时全部丢弃
        //  RoundingMode.HALF_EVEN 目前测试的结果是四舍五入
        //  RoundingMode.HALF_UP 目前测试的结果是四舍五入
        //  RoundingMode.HALF_DOWN 目前测试的结果是舍弃时全部丢掉
        //  RoundingMode.CEILING 舍弃时最后一位+1  注意尾数为9时 最后一位变0 倒数第二位+1
        //  RoundingMode.FLOOR 目前测试的结果是舍弃时全部丢掉
        //  RoundingMode.FLOOR 目前测试的结果是舍弃时全部丢掉
        // RoundingMode.UNNECESSARY  唯一抛异常的 目前整不明白
        /*
        double num = 12.123456789;
        BigDecimal big = new BigDecimal(num);
        System.out.println(big.setScale(2,RoundingMode.HALF_UP));
        */
    }

}
