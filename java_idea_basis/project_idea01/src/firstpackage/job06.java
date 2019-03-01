package firstpackage;

/*
8点开搞
本以为最多12点能写完 愣是写到吃完饭
收获:
    1.线段分割法 :  适用于这种数量规模确定的随机场景
   2. double 不损失精确地的操作方式  import java.math.BigDecimal;
                                     import java.math.MathContext;
                                     import java.math.RoundingMode;
 */

/*
通过继承开发一个群主发红包 群内大佬抢红包的小案例
伪码如下:
    基类 User:
        private name
        private monley
用户构造 User(name monley){
        }
        method getter name
        method setteer name
        method getter monley
        method setter monley
        method show user

// 创建对象模板群主 群主有发红包功能
    子类 群主:
        使用基类构造方法
        获取群主余额
        将群主的输入的金额分若干份放到列表中
        (至于多长时间未抢到则返回群主余额这种功能 目前对java的时间系列不太了解 暂时不做)

//  创建对象 吃瓜群众  群众要有抢红包功能
    子类 吃瓜群众
        使用基类构造方法
        获取吃瓜群众余额
        吃瓜群众有抢红包功能  将列表与列表的随机下标索引传入抢红包功能中

// 程序的启动入口:
    创建群主对象
    创建大量吃瓜群众对象
    吃瓜群众开始抢红包
    未获得红包列表的吃瓜群众返回消息 哎哟 手速慢了

难点 红包算法的实现:
    之前自己写的;
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
    线段分割法:

 */

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.*;

import static java.math.BigDecimal.*;

public class job06 {
    public static void main(String[] args) {
        // 群主发红包
        haremMaster haer = new haremMaster("小赵",100);
        List<Double> redlist = haer.redEnvelope(100,20);

        // 创建一个装20个群员对象的数组
        ChiguatheMasses[] chiguath = new ChiguatheMasses[21];
        int x=0;
        while(x<=chiguath.length-1){
            String zhang = Integer.toString(x);
            String zhang1 = "张";
            chiguath[x] = new ChiguatheMasses(zhang1.concat(zhang),0);
            x++;
        }
        int y = 0;
        while(y<=chiguath.length-1){
            chiguath[y].snatchRedEnvelope(redlist);
            y++;
        }

        System.out.println(redlist.toString());
    }
}

/**
 * 用户类 基类
 * 用户的基本信息
 * 开放 name的set与get
 * 开放leftMoney的get与set
 * 开放构造 name 与 leftMoney
 */
class User{
    private String name;
    private double leftMoney;

    public User() {
    }

    public User(String name, double leftMoney) {
        this.name = name;
        this.leftMoney = leftMoney;
    }

    // 返回对象名
    public String getName() {
        return name;
    }

    // 设置对象名字
    public void setName(String name) {
        this.name = name;
    }

    //  返回对象余额
    public double getLeftMoney() {
        return leftMoney;
    }

    // 设置对象余额
    public void setLeftMoney(double leftMoney) {
        this.leftMoney = leftMoney;
    }

    // 展示用户信息
    public void show(){
        System.out.println(name);
        System.out.println(leftMoney);
    }
}

class haremMaster extends User{
    public haremMaster(String name, double leftMoney) {
        super(name, leftMoney);
    }

    /*发红包功能
      红包算法的实现
      生成一个 size 长为 part+1的 容器
      元素从0开始 money参数结尾
      通过 第一个元素减去第0个元素(0索引元素为0) 第二个减去第一个元素 以此类推  互减最后的到的值相加即为 参数 money
     */
    public List<Double> redEnvelope(double money, int part){
        // 准备随机红包列表
        List<Integer> list = new ArrayList<>();
        // 将传入的money*100 方便运算
        int money1 = (int)(money*100);
        // 向list添加以确定的元素
        list.add(0);
        list.add(money1);
        while(list.size()<=part){
            // 向列表添加随机元素
            int money2 = new Random().nextInt(money1-1)+1;
            if(list.contains(money2)){
                // 如果元素已包含 跳过这次
                continue;
            }
            list.add(money2);
        }
        // 对容器元素排序
        Collections.sort(list);

        // 真正的红包列表
        List<Double> list2 = new ArrayList<>();
        for (int y=0; y<list.size()-1; y++){
            // 第一个元素减去第0个元素(0索引元素为0) 第二个减去第一个元素 的到随机红包金额
            double money3 = list.get(y+1)-list.get(y);
            /* 之前乘过100  现在除回来
             通过翻阅文档查资料  终于找到了解决浮点数运算的问题
              + - * / 分别对应为 add subtract multiply divide
              可根据选择对结果进行保留位数与四舍五入
                +   MathContext.   根据精确要求自行选择
                -
            */
            BigDecimal big = new BigDecimal(money3);
            BigDecimal big2 = new BigDecimal(100);
            big = big.divide(big2, 2, RoundingMode.HALF_UP);
            double money5 = Double.parseDouble(big.toString());
            list2.add(money5);
        }

        // 测试是否有精确度丢失   舒服
        BigDecimal num2 = new BigDecimal(0);
        for(double num: list2){
            // 测试是否有精确度丢失   舒服
            BigDecimal big = new BigDecimal(num);
            num2 = num2.add(big, MathContext.DECIMAL32);

        }
        // System.out.println(num2);
        return list2;
    }


}


/**
 * 群员群
 * 构造群员 并拥有抢红包功能
 */
class ChiguatheMasses extends User{
    public ChiguatheMasses(String name, double leftMoney) {
        super(name, leftMoney);
    }

    public void snatchRedEnvelope(List<Double> list){
        // 产生随机下标索引


        // 一个预期之外的错误  我的错误写法导致的
        //int index = new Random().nextInt((list.size()-1)+1;
        if(list.size()!=0) {
            int index = new Random().nextInt(((list.size() - 1)) + 1);
            double money = list.get(index);
            list.remove(money);
            System.out.println(super.getName() + "抢到::" + money);
            super.setLeftMoney(money);
        }else{
            System.out.println("手速真慢 红包没了");
        }
    }
}


