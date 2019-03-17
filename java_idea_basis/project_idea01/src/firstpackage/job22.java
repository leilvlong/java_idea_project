package firstpackage;
/*
位运算符(按位操作符):
    位运算符操作的是bit(每个bit为一个二进制单位)
    与(&) 两个操作数的 位 都为1  结果才为1 否则结果为0
    非(~) 如果操作数 位为0 结果为1 如果位为1 结果为0
    或(|) 两个操作数的 位 只要一个为1  结果为1 否则为0
    异或(^) 两个操作数的 位 相同结果为0, 不同则为1
    按位操作符会对两个参数中对应的位执行布尔代数运算 并最终生成一个结果

     算了 暂时牛角尖了  搞不懂
     \= 的规则总结应该是没错的   剩下的不准确
    &=  返回运算符右边的操作数相等的位数(满足基本规则的前提下)
    \=  返回运算符右边的操作数相等的 位数
    ^=
 */
public class job22 {
    public static void main(String[] args) {
        AnOperator2();
        AnOperator();
    }

    //位运算符
    public static void AnOperator(){
        int num1 = 80;
        int num2 = 160;
        //查看他们的二进制数字
        //System.out.println(job19.binary(num1));
        //System.out.println(job19.binary(num2));

        System.out.println("与(&):   " + (num1 & num2)  );
        //System.out.println("非(~):   " + (~num1) + (~num2) );
        //System.out.println("或(|):   " + (num1 | num2));
        //System.out.println("异或(^): " + (num1 ^ num2));
    }

    public static void AnOperator2(){
        int num1 = 80;
        int num2 = 160;
        //查看他们的二进制数字
        System.out.println(job19.binary(num1));
        System.out.println(job19.binary(num2));
        System.out.println("与(&):   " + (num1 &= num2)  );
        //System.out.println("或(|):   " + (num1 |= num2));
        System.out.println("异或(^): " + (num1 ^= num2));
    }
}
