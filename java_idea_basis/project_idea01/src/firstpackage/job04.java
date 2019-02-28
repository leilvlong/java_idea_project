package firstpackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
面向对象要注重于出现的对象而非过程
如果不写注释  程序毫无意义

做一个猜测的小游戏 需要累计击中三次目标才算完成 此时结束游戏
 */
public class job04 {
    public static void main(String[] args){
        // 计数器 用来计算玩家花了多少次才结束游戏
        int numOfGuess = 0;

        // 获取用户输入
        GameHelper helper = new GameHelper();

        // 创建SimpleDotCom对象 并传入必要参数
        SimpleDotCom theDotCom = new SimpleDotCom();
        int random = (int)(Math.random()*5);
        int[] locations = {random, random+1, random+2};
        theDotCom.setLocation(locations);

        // 游戏的启动使用while循环  当满足游戏时  将boolean改为false 则游戏结束
        boolean isAlive=true;
        while(isAlive){
            String guess = helper.getUserInput("请输入number");
            String result = theDotCom.checkYourself(guess);
            numOfGuess++;
            if(result=="kill"){
                isAlive = false;
                System.out.println("you took "+ numOfGuess + "  guesses");
            }

        }
    }
}


class SimpleDotCom{
    // 不允许随意修改游戏参数
    private int[] location;
    private int numOfHits = 0;

    public void setLocation(int[] loca){
        // 设置参数并初始化数组 用来开始游戏
        location = loca;
    }

    public String checkYourself(String guess){
        /*
        用户游戏逻辑的处理
         */
         //将传入的String 转为 int
        int num = Integer.parseInt(guess);
        // 当击中时才显示为hit  未击中则为miss
        String result = "miss";
        for (int cell:location){
            // 多是否击中的逻辑处理
            if(num==cell){
                result = "hit";
                numOfHits++;
                break;
            }
        }
        if(numOfHits ==location.length){
            // 当累计击中次数与数组长度相同时 代表游戏结束
            result = "kill";
        }
        System.out.println(result);
        // 返回游戏结果
        return result;
    }
}

class GameHelper{
    /*
    获取用户输入
     */
    public String getUserInput(String prompt){
        String inputLine = null;
        System.out.println(prompt);
         // try 语句  抛出异常(滑稽.jpg)
        try{
            /*
            官方文档说明:
                从字符输入流中读取文本，缓冲字符，以便有效地读取字符，数组和行。
                InputStreamReader是从字节流到字符流的桥接器
            */
            BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
            // 将字符读取
            inputLine = is.readLine();
            if(inputLine.length() == 0){
                return null;
            }
        }catch(IOException e){
            //既然使用了字节流  就难免抛出异常
            System.out.println("IOException:"+e);
        }
        return inputLine;
    }

}