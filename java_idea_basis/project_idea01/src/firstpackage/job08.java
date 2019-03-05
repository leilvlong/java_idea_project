package firstpackage;

import jdk.swing.interop.SwingInterOpUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;

public class job08 {

    public static void main(String[] args) {
        // 创建游戏对象
        DotComBust game = new DotComBust();
        // 初始化设置
        game.setUpGame();
        // 启动游戏
        game.startPlaying();
    }

}

/**
 * 游戏对象的初始化与启动都在这里
 */
class DotComBust{
    // 创建游戏帮助对象
    private GameHelp help = new GameHelp();
    // 用来装DotCom的容器
    private ArrayList<DotCom> dotComArrayList =new ArrayList<>();
    // 计数器 玩家花了多少次
    private int numOfGuesses = 0;

    public void setUpGame(){
        // 游戏的初始化
        DotCom oneDotCom = new DotCom();
        oneDotCom.setName("Pets.com");
        DotCom twoDotCom =new DotCom();
        twoDotCom.setName("eToys.com");
        DotCom threeDotCom = new DotCom();
        threeDotCom.setName("Go2.com");
        dotComArrayList.add(oneDotCom);
        dotComArrayList.add(twoDotCom);
        dotComArrayList.add(threeDotCom);

        //简短的提示
        System.out.println("your goal is to sink three dot coms.");
        System.out.println("pets.com, eToys.com, Go2.com");
        System.out.println("Try to sink them all in the fewest number of guesses");

        // 循环遍历 dotComArrayList 容器中的每个对象 并对他们进行设置
        for(DotCom dotComTest: dotComArrayList){
            // 获取随机坐标的值
            ArrayList<String> newLocation = help.palceDotCom(3);
            // 将获取的坐标置入容器中
            dotComTest.setLocationsCells(newLocation);
        }
    }

    public void startPlaying(){
        // 7.判断 dotComArrayList是否为空
        while(!dotComArrayList.isEmpty()){
            // 8.取得玩家输入
            String userGuess = help.getUserInput("Enter a guess");
            // 9.调用checkUserGuess
            checkUserGuess(userGuess);
        }
        // 10.调用finishGame方法
        finishGame();
    }

    public void checkUserGuess(String userGuess){
        // 11.递增玩家猜测次数的计数
        numOfGuesses++;
        // 12.先假设没有命中
        String result = "miss";
        // 13.对dotComArraylist中所有的DotCom重复
        for(DotCom dotComTest:dotComArrayList){
            // 14.要求检查DotCom检查是否命中或击沉
            result = dotComTest.checkYourself(userGuess);
            if (result.equals("hit")){
                // 15.提交跳出循环
                break;
            }
            if(result.equals("kill")){
                // 16.这家伙被挂掉了
                dotComArrayList.remove(dotComTest);
                break;
            }
        }
        //17.列出结果
        System.out.println(result);
    }

    public void finishGame(){
        // 18.列出玩家成绩
        System.out.println("All Dot Coms are dead! your stock is now worthless");
        if(numOfGuesses <=18){
            System.out.println("It only took you " + numOfGuesses+ " guesses." );
            System.out.println("You got out before your options sank.");
        }else{
            System.out.println("Took you long enough. "+ numOfGuesses+" guesses.");
            System.out.println("Fish are dancing with your options.");
        }
    }

}

class GameHelp{
    // y轴坐标
    private static final String alphabet = "abcdefg";
    // x轴长度
    private int gridLength =7;
    // 容器大小
    private int gridSize = 49;
    /*
    坐标记录容器  七行七列所有坐标占位值最多为49
    (坐标值占位置为  1 - (girdLength*gitdLength) )
      行坐标 row = 随机坐标占位值 / girdLength  的商
      列坐标 column = 随机坐标占位值 % girl  的余

     */
    private int[] grid = new int[gridSize];
    private int comCount=0;



    public ArrayList<String> palceDotCom(int comSize){
        //生成的随机坐标将被装进容器返回
        ArrayList<String> alphaCells = new ArrayList<>();

        // 存放随机坐标
        int[] coords =new int[comSize];

        // 循环控制器                          //g  43  44  45  46  47  48  49
        boolean success=false;               //f   36  37  38  39  40  41  42
                                              //e   29  30  31  32  33  34  35
        // 坐标占位值初始化                   //d   22  23  24  25  26  27  28
        int location= 0;                      //c   15  16  17  18  19  20  21
                                              //b   8   9   10  11  12  13  14
        // 计数处理第n个坐标                  //a   1   2   3   4   5   6   7
        comCount++;                          //    1   2   3   4   5   6   7
        // 垂直或水平  奇数垂直 偶数水平
        int incr=1;
        if((comCount%2)==1){
            // 避免随机坐标占位值越界
            incr = gridLength;
        }

        while(!success ){
            // 产生一个随机坐标
            location = (int)(Math.random()*gridSize);
            int x =0;
            // ! 取反  设置值为true后取false  等下面循环结束未触发控制success语句时 结束本循环
            success=true;
            // 设置随机坐标的条件控制语句 当设置了三个三个随机坐标后 才可进行下一步
            while(success&& x < comSize){
                // 如果随机坐标的值为0
                if(grid[location]==0){
                    // 容器 coords 保存随机坐标
                    coords[x++] = location;
                    location+= incr;
                    if(location>=gridSize){
                        // 不允许随机坐标越界
                        success = false;
                    }
                    if(x > 0 && (location%gridLength==0)){
                        success = false;
                        // 不允许随机坐标越界
                    }
                }else{
                    // 如果该坐标已经有值
                    success = false;
                }
            }
        }
        System.out.println(Arrays.toString(coords));
        String temp = null;
        int x=0;  // 计数器
        int row=0; // x轴
        int column=0;  // y轴
        while(x<comSize){
            // 代表该坐标以被拥有
            grid[coords[x]]=1;
            // 计算y 轴 与x轴各自对应的坐标  拼接成字符串返回
            row = (int)(coords[x]/gridLength);
            column = coords[x]%gridLength;
            // 字符串索引从0开始 所以这个公式当前程序没问题
            temp = String.valueOf(alphabet.charAt(row));
            alphaCells.add(temp.concat(Integer.toString(column)));
            x++;
        }
        // 返回坐标
        System.out.println(alphaCells.toString());
        return alphaCells;
    }

    public String getUserInput(String promtp){
        // 获取用户输入
        String inputLine = null;
        System.out.println(promtp + ":  ");
        try{
        BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
        inputLine = is.readLine();
        if(inputLine.length()==0){
            return null;
        }
        }catch(IOException e){
            System.out.println("IOException");
        }
        return inputLine;
    }

}

class DotCom{
    private String name;
    // 用来存放随机坐标的容器
    private ArrayList<String> locationsCells;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getLocationsCells() {
        return locationsCells;
    }

    public void setLocationsCells(ArrayList<String> locationsCells) {
        this.locationsCells = locationsCells;
    }

    public String checkYourself(String userInput){
        //  用户与游戏交互区
        String result = "miss";
        // 如果用户输入的坐标在容器中 则会返回索引
        int index = locationsCells.indexOf(userInput);
        if(index>=0){
            // 用户击中 删除坐标 返回状态
            locationsCells.remove(index);
            if(locationsCells.isEmpty()){
                result = "kill";
                System.out.println("Ouch! you sunk"+ name + "   : (");
            }else{
                result = "hit";
            }
        }
        // 返回状态给用户
        return result;
    }
}