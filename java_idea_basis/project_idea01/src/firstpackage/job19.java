package firstpackage;

import java.util.ArrayList;
import java.util.Collections;

/*
十进制转2进制:
    除2倒取余
二进制转十进制:
    8421对应  0表示没有 1表示存在  然后累加

十六进制转十进制
    例子: 3FA7
        7  7*16^0           7
        A  A*16^1         160
        F  F*16^2        3840
        3  3*16*3       12288
        ----------------------
                        16295
十六进制转二进制
    每一位数代表 4个进制 并除2倒取余 ,不足4位二进制以0在计算结果左边填充
    例子: 3AF5
        5   0101
        F   1111
        A   1010
        3   0011
        --------------
        0011 1010 1111 0101 换算10进制即 15093

二进制转十六进制:
    例子:   10 1010 0101 1011  不满4位则以0在左边填充
    1011    B
    0101    5
    1010    A
    0010    2
    ----------
         2A5B

十进制转十六进制:
    对照关系:
        十进制 :   0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11. 12, 13, 14, 15
       十六进制:   0, 1, 2, 3, 4, 5, 6, 7, 8, 9,  A, B,  C,  D,   E,  F
       暂时想不到方法 麻烦一点 转二进制在转十六进制
 */
public class job19 {
    public static void main(String[] args) {
        decimal(binary(103));
    }

    // 十进制数字转二进制
    public static ArrayList<Integer> binary(int num){
        // 除2倒取余 获取十进制
        ArrayList<Integer> binaryNums = new ArrayList<>();
        int brnaryNum;
        while(true){
            brnaryNum = num%2;
            binaryNums.add(brnaryNum);
            num = num/2;
            if(num==0){
                break;
            }
        }
        // 翻转ArrayList达到倒取余效果
        Collections.reverse(binaryNums);
        return binaryNums;
    }

    public static void decimal(ArrayList<Integer> list){
        int sum = 0;
        int binaryCount=1;
        for (int i = list.size()-1; i>=0; i--) {
            if(list.get(i)==0){

            }else{
                sum+=binaryCount;
            }
            binaryCount = binaryCount*2;
        }
        System.out.println(sum);
    }
}
