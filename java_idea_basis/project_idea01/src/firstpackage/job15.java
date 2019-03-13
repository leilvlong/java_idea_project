package firstpackage;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/*
对于有索引的数据容器
可以想象为一条线段
这样操作起来 脑子里面进行逻辑规划时会更加容易
 */
public class job15 {
    public static void main(String[] args) {
        // 扑克牌
        ArrayList<String> cards = new ArrayList<>();
        // 花色
        String[] color = {"♥","♠","♣","♦"};
        // 牌点数
        String[] count = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
        for (String s : color) {
            for (String c : count) {
                cards.add(s+c);
            }
        }
        cards.add("♛");
        cards.add("۩");
        Collections.shuffle(cards);

        ArrayList<String> player1 = new ArrayList<>();
        ArrayList<String> player2 = new ArrayList<>();
        ArrayList<String> player3 = new ArrayList<>();
        ArrayList<String> card = new ArrayList<>();
        for (int x = 1; x <= cards.size(); x++) {
            if(cards.size()-x<3){
                card.add(cards.get(x-1));
            }else if(x%3==0){
                player1.add(cards.get(x-1));
                player2.add(cards.get(x-2));
                player3.add(cards.get(x-3));
            }
        }
        System.out.println(player1);
        System.out.println(player2);
        System.out.println(player3);
        System.out.println(card);
    }

    public static void strChar(){
        String str = "abcd";
        char[] chars = new char[15];
        char[] chasr1= str.toCharArray();
        for (int x = 1; x <= chars.length; x++) {
            if(x%chasr1.length==0){
                System.arraycopy(chasr1,0,chars,(x-chasr1.length),chasr1.length);
            }else if(chars.length%chasr1.length==x){
                System.arraycopy(chasr1,0,chars,(chars.length-x),x);
            }
        }
        System.out.println(Arrays.toString(chars));
    }
}


