package firstpackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class job09 {
    public static void main(String[] args) {
        ColorBall colorBall = new ColorBall();
        colorBall.run();
    }
}

/**
 * 双色球游戏
 * 红球 1-33
 * 篮球 1-16
 * 用户输入红蓝求
 * 系统进行匹配
 * 返回相应状态或消息
 *
 */

class ColorBall{
    Random r = new Random();
    Scanner sc = new Scanner(System.in);

    public void run(){
        // 1. 创建双色球游戏对象
        ColorBall colorBall = new ColorBall();
        // 2. 被选中的红球数组
        int[] systemRed = colorBall.returnRedBall();
        System.out.println(Arrays.toString(systemRed));

        // 3. 被选中的蓝色球号码
        int systemBlue = colorBall.returnBlueBall();
        System.out.println(systemBlue);

        // 4. 用户选择六个红球号码
        int[] userRed = colorBall.getUserRedBall();
        System.out.println(Arrays.toString(userRed));


        // 5. 用户选择一个篮球
        int userBlue = colorBall.getUserBlueBall();
        System.out.println(userBlue);


        // 6. 开奖红球
        int redNumber = colorBall.winningRedMessage(systemRed, userRed);

        // 7. 开奖蓝球
        boolean iswinning = colorBall.winningBlueMessage(systemBlue,userBlue);

        System.out.println("请中奖的朋友持双色球彩票前往彩票站点领奖");


    }


    public int winningRedMessage(int[] returnRedBall, int[] getRedBall){
        ArrayList list = returnWinning(returnRedBall,getRedBall);
        switch (list.size()){
            case 6:
                System.out.println("恭喜你中了六个红球 中奖球号为:");
                forArray(list);
                return list.size();
            case 5:
                System.out.println("恭喜你中了五个红球 中奖球号为:");
                forArray(list);
                return list.size();
            case 4:
                System.out.println("恭喜你中了四个红球 中奖球号为:");
                forArray(list);
                return list.size();
            case 3:
                System.out.println("恭喜你中了三个红球 中奖球号为:");
                forArray(list);
                return list.size();
            case 2:
                System.out.println("恭喜你中了二个红球 中奖球号为:");
                forArray(list);
                return list.size();
            case 1:
                System.out.println("恭喜你中了一个红球 中奖球号为:");
                forArray(list);
                return list.size();
            default:
                System.out.println("很遗憾 没有中奖!");
                return 0;
        }
    }

    public boolean winningBlueMessage(int systemBlueBall,int userBlueBall){
        if(systemBlueBall == userBlueBall){
            System.out.println("恭喜你,蓝球中了! 蓝球号码为: \n"+systemBlueBall);
            return true;
        }else{
            System.out.println("很遗憾,蓝球没中! 蓝球号码为: \n"+systemBlueBall);
            return  false;

        }
    }


    /**
     * @return 返回被选中红球号码数组
     */
    public int[] returnRedBall(){
        int [] redBallNumber = new int[6];
        int index =0;
        while(true){
           int addRedBall=(r.nextInt(33)+1);
           if(forBall(addRedBall,redBallNumber)){
               continue;
           }else{
               redBallNumber[index++] = addRedBall;
               if(index == redBallNumber.length){
                   Arrays.sort(redBallNumber);
                   return redBallNumber;
               }
           }
        }
    }

    /**
     * @return  返回被选中的蓝色球号码
     */
    public int returnBlueBall(){
        return (r.nextInt(16)+1);
    }

    /**
     * 返回用户所选择的红球号码数组
     * @return 如果用户输入非法 则返回null并提示用户重新输入
     * 否则返回用户选择的红球号码数组
     */
    public int[] getUserRedBall(){
        int[] userRedBall = new int[6];
        int index = 0;
        System.out.println("请选择1--33之间的球号: ");
        while(true){
            System.out.println("你的第 " + (index+1) + " 个号码");
            if(sc.hasNextInt()){
                int addRedBALL = sc.nextInt();
                if(forBall(addRedBALL,userRedBall)){
                    System.out.println("该号码已经选过,请重新选择!");
                    continue;
                }else if((addRedBALL > 33) || addRedBALL<0) {
                    System.out.println("输入范围不符!! 只允许选号 1 -- 33!");
                    continue;
                } else {
                    userRedBall[index++] = addRedBALL;
                    if (index == userRedBall.length) {
                        Arrays.sort(userRedBall);
                        return userRedBall;
                    }
                }
            }else{
                System.out.println("输入非法!! 只允许选号 1 -- 16");
                System.out.println("请重新选号");
                return null;
            }
        }
    }

    /**
     * @return 返回用户的篮球号码 如果输入非法 返回0 并提示重新选择
     */
    public int getUserBlueBall(){
        while(true){
            System.out.println("请选择1--16之间的球号: ");
            if(sc.hasNextInt()){
                int addBlueball = sc.nextInt();
                if(addBlueball>16 || addBlueball<0){
                    System.out.println("没有这个球号!请输入1--16之间的号码球!");
                    continue;
                }
                return addBlueball;
            }else{
                System.out.println("输入非法!! 只允许选号 1 -- 16");
                System.out.println("请重新选号");
                return 0;
            }
        }
    }

    /**
     * @param returnRedBall  系统产生的红球中奖号码
     * @param getRedBall   用户选择的红球号码
     * @return 返回用户具体的中奖红球球号
     */
    public ArrayList<Integer> returnWinning(int[] returnRedBall, int[] getRedBall){
        ArrayList<Integer> winningNumber = new ArrayList<>();
        for(int x:returnRedBall){
            for(int y:getRedBall){
                if(x==y){
                    winningNumber.add(y);
                }
            }
        }
        return winningNumber;

    }


    /**
     *
     * @param redBall 元素
     * @param redList 数组
     * @return 如果数组中包含这个元素 返回true 否则false
     */
    public static boolean forBall(int redBall, int[] redList) {
        // 检查是否有重复元素
        for (int x : redList) {
            if (x == redBall) {
                return true;
            }
        }
        return false;
    }

    public void forArray(ArrayList<Integer> list){
        for (int x = 0; x < list.size(); x++) {
            if(x==(list.size()-1)){
                System.out.println(list.get(x));
            }else {
                System.out.print(list.get(x) + "  ");
            }
        }
    }
}

