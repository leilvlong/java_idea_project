package firstpackage;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * 关于抢红包案例的算法补充
 */
public class jobo6_replenish {
    public static void main(String[] args) {
//        // 之前的红包算法
//        System.out.println(fun1(100,10));
        // 今天接触的一种算法
        System.out.println(fun2(100,10));

    }

    /**
     * 线段切割算法的红包算法
     * @param money  金额
     * @param part    红包数
     * @return  随机红包
     */
    public static ArrayList<Double> fun1(double money, int part){
        // 用来切割红包线
        Random r = new Random();
        // 被切割的红包线的容器
        ArrayList<Integer> redLine = new ArrayList<>();
        // 方便运算 至少在做乘100时 double还没出现过精度丢失  如果必要可以使用BigDecimal
        int newmoney = (int)(money*100);
        // 红包线的起点与终点
        redLine.add(0);
        redLine.add(newmoney);
        // 添加被切割的红包线段
        while(redLine.size()<= part){
            int lineSegment =r.nextInt(newmoney)+1;
            if(redLine.equals(lineSegment)){
                // 避免重复
                continue;
            }
            redLine.add(lineSegment);
        }
        Collections.sort(redLine);
        // 利用红包线段得出红包金额 存放的容器
        ArrayList<Double> redPacket = new ArrayList<>();
        for (int i = 0; i < redLine.size()-1; i++) {
            int redMoney = redLine.get(i+1)-redLine.get(i);
            // 对数据进行精确运算 防止精确度丢失
            BigDecimal big = new BigDecimal(redMoney);
            BigDecimal big2 = new BigDecimal(100);
            big = big.divide(big2,2, RoundingMode.HALF_UP);
            money = Double.parseDouble(big.toString());
            redPacket.add(money);
        }
        return redPacket;
    }

    public static ArrayList<Double> fun2(double money, int part) {
        // 创建随机数对象
        Random r = new Random();
        // 用来记录剩余的金额
        int leftMoney = (int)(money*100);
        // 用来记录剩余红包个数
        int leftCount = part;
        // 创建集合
        ArrayList<Double> list = new ArrayList<>();
        // 最后一个不用计算, 剩下多少钱就是最后一个包的金额
        for (int i = 0; i < part - 1; i++) {
            // 将红包等分
            int perMoney = leftMoney / leftCount;
            // 红包范围 (0.01元  ~  等分 * 2)
            int min = 1; // 1分
            int max = perMoney * 2;
            // 计算随机红包金额
            int newmoney = (int) (r.nextDouble() * max);
            // 极限值的判断
            newmoney = newmoney < 1 ? 1 : newmoney;
            list.add(   Double.parseDouble(new BigDecimal(newmoney)
                    .divide(new BigDecimal(100),2,RoundingMode.HALF_UP)
                    .toString()
                    )
                );
            // 修改剩余金额和剩余红包个数
            leftMoney -= newmoney;
            leftCount--;
        }
        // 剩多少钱都给最后一个包
        list.add(Double.parseDouble(new BigDecimal(leftMoney)
                .divide(new BigDecimal(100),2,RoundingMode.HALF_UP)
                .toString()));
        return list;
    }
}
