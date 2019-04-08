package com.itheima.job04;

import java.util.ArrayList;

public class job05 {
    public static void main(String[] args) {
        /*new Thread(()->{
            for (int i = 0; i < 1000; i++) {
                System.out.println("bbbbb");
            }
        }).start();*/
        Studens stu = new Studens(-1);
    }
}



class Studens{
    private int sc;

    public Studens(int sc){
        try{
            if(sc<0){
                throw new CustomException("分数不能为负数");
            }else{
                this.sc = sc;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

class CustomException extends Exception{

    public CustomException(String message) {
        super(message);
    }
}