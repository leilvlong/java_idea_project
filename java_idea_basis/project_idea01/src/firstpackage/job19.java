package firstpackage;

import java.util.ArrayList;
import java.util.Collections;

/*
十进制转2进制
验证是否准确
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
        System.out.println(binaryNums);
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
