package com.itheima.job01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.MathContext;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * 设置height*lenght 的网格 然后随机残生特殊格子被对手占据
 * 输入 例如A3  G5 等数据进行游戏  击中所有特殊格子即获得胜利
 */

/**
 * 伪码:
 *      main:
 *          创建对象
 *          初始化对象
 *          启动游戏
 *    游戏对手:
 *          名字
 *          所在坐标
 *          method:
 *              如果被用户成功击中我的坐标的处理逻辑
 *    游戏帮助:
 *          method:
 *              生成游戏随机坐标返回给用户
 *          method:
 *              获取用户输入
 *    游戏运行:
 *          method:
 *              初始化游戏对手
 *          method;
 *              开始游戏
 *         method:
 *              帮助开始游戏处理一部分逻辑:
 *                  获取每一个对手 对用户输入进行处理
 *                  如果被用户成功击中坐标的处理逻辑
 *                  无论用户是否击中 返回消息后都应该让用户重新输入
 *         method:
 *              返回用户记录
 */


public class day04 {
    public static void main(String[] args) {
        DotComBust dotComBust = new DotComBust();
        dotComBust.setUpGanme();
        dotComBust.stratGame();
    }
}

/**
 * 游戏对手
 */
class DotCom{
    // 对手名称
    private String name;
    // 对手所在的坐标
    private ArrayList<String> coordinateList = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getCoordinateList() {
        return coordinateList;
    }

    public void setCoordinateList(ArrayList<String> coordinateList) {
        this.coordinateList = coordinateList;
    }

    /**
     * 对用户猜测坐标的处理(交互)
     * @param userGuess 用户猜测的坐标
     * @return 用户的猜测状态
     * 如果里面的都坐标被清楚 返回给用户相应的状态
     */
    public String checkHit(String userGuess){
        String result = "miss";
        int index = coordinateList.indexOf(userGuess);
        if(index>=0){
            coordinateList.remove(index);
            if(coordinateList.isEmpty()){
                result = "kill";
                System.out.println("Oh! you sunk"+ name + "   : (");

            }else{
                result = "hit";
            }
        }

        return result;
    }
}

/**
 * 游戏辅助
 * 生成游戏随机坐标
 * 获取用户输入
 */
class GameHleper{
    /*
        获取网格为 heigth * length
        在产生随机占位值后
        行 = 随机占位值 / lenght  (行从0开始计数)
        列 = 随机占位值 % lenght  (列从1开始计数)
     */
    private String gridHeight = "abcdefg";
    private int gridLength = 7;
    private int[] grid = new int[49];
    private int  control = 0;

    public ArrayList<String> createCoordinate(int num){
        //  装有随机坐标的容器  生成的坐标将被放在这里返回
        ArrayList<String> coordinate = new ArrayList<>();

        // 生成的随机占位值将被放在这个容器里  用来解析成为具体的坐标值
        int[] locations = new int[num];
        // 随机占位值坐标
        int location = 0;

        //  垂直或水平的辅助生成坐标控制器
        control++;
        int incr =(int)(Math.random()*5);
        if(control%2==1){
            incr = 7;
        }

        // 生成随机坐标循环的控制器
        boolean success = false;

        // 生成随机坐标的循环
        while(!success){
            success = true;
            int x = 0;
            location = (int)(Math.random()*grid.length);
            while( success && x<num){
                if(grid[location]==0){
                    locations[x++] = location;
                    location+=incr;
                    if(location>=grid.length){
                        success = false;
                        break;
                    }else if(x>0 && location%7==0){
                        // 如果占位值整除等于0会很尴尬
                        success = false;
                        break;
                    }
                }else{
                    success = false;
                }
            }
        }
        System.out.println(Arrays.toString(locations));
        int x=0;
        String temp=null;
        int row =0;
        int column = 0;
        while(x<num){
            grid[locations[x]] =1;

            // y轴 (行)
            column = locations[x]/gridLength;
            // x轴(列)
            row = locations[x]%gridLength;
            temp = String.valueOf(gridHeight.charAt(column)).concat(Integer.toString(row));
            coordinate.add(temp);
            x++;
        }
        System.out.println(coordinate);
        return coordinate;
    }

    public String getUserInput(){
        String userInput = null;
        System.out.println("请输入猜测坐标:  ");
        try{
            BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
            userInput = buff.readLine();
            if(userInput.length()==0){
                return null;
            }
        }catch (IOException e){
            System.out.println("IOEception");
        }

        return userInput;
    }

}



class DotComBust{
    private GameHleper help = new GameHleper();
    private ArrayList<DotCom> dotComs= new ArrayList<>();
    private int numOfCount = 0;

    public void setUpGanme(){
        // 对手的初始化
        DotCom pets = new DotCom();
        pets.setName("pets.com");
        DotCom dot = new DotCom();
        dot.setName("dot.com");
        DotCom lab = new DotCom();
        lab.setName("lab.com");
        dotComs.add(pets);
        dotComs.add(dot);
        dotComs.add(lab);

        // 设置对手的每个坐标
        for(DotCom dotCom:dotComs){
            ArrayList location = help.createCoordinate(3);
            dotCom.setCoordinateList(location);
        }
    }

    public void stratGame(){
        while(!dotComs.isEmpty()){
            String userGuess = help.getUserInput();
            checkUserGuess(userGuess);
        }
        finGame();
    }

    public void checkUserGuess(String userguess){
        String result = "miss";
        numOfCount++;
        for(DotCom dotCom:dotComs){
            result = dotCom.checkHit(userguess);
            if(result.equals("hit")){
                break;
            }
            if(result.equals("kill")){
                dotComs.remove(dotCom);
                break;
            }
        }
        System.out.println(result);
    }

    public void finGame(){
        // 18.列出玩家成绩
        System.out.println("成功击杀全部对手");
        if(numOfCount <=18){
            System.out.println("it only took you " + numOfCount+ " guesses." );
            System.out.println("You got out before your options sank.");
        }else{
            System.out.println("Took you long enough. "+ numOfCount+" guesses.");
            System.out.println("Fish are dancing with your options.");
        }
    }
}
