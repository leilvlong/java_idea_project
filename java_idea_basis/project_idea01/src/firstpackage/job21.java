package firstpackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class job21 {
    public static void main(String[] args) {
        // 再写斗地主洗牌 发牌 看牌
        licEnsing();
    }

    // 发牌与看牌
    public static void licEnsing(){
        //获取地主牌
        HashMap<Integer, String> poker = makerPoker();
        // 获取取得牌的key
        ArrayList<Integer> pokerKeys = new ArrayList<>(poker.keySet());
        // 打乱它  达到洗牌的效果
        Collections.shuffle(pokerKeys);
        // 发牌
        HashMap<String, ArrayList<Integer>> players = player(pokerKeys);
        ArrayList<Integer> player1 = players.get("player1");
        ArrayList<Integer> player2 = players.get("player2");
        ArrayList<Integer> player3 = players.get("player3");
        ArrayList<Integer> card = players.get("card");
        // 看牌
        pokerShow(player1,poker,"player1");
        pokerShow(player2,poker,"player2");
        pokerShow(player3,poker,"player3");
        pokerShow(card,poker,"card");


    }

    // maker poker
    public static HashMap<Integer,String> makerPoker(){
        // 扑克容器
        HashMap<Integer,String> poker = new HashMap<>();
        // 制造扑克牌放入扑克容器
        String[] colors = {"♦","♣","♥","♠"};
        String[] pokerNum = {"3","4","5","6","7","8","9","10","J","Q","K","A","2"};
        int index = 1;
        for (int x = 0; x < pokerNum.length; x++) {
            for (int y = 0; y < colors.length; y++) {
                poker.put(index++,colors[y]+pokerNum[x]);
            }
        }
        poker.put(index++,"۩");
        poker.put(index,"♛");
        return poker;
    }

    // 游戏玩家获取扑克牌
    public static HashMap<String,ArrayList<Integer>> player(ArrayList<Integer> list){
        // 将玩家的牌放入Map 中返回
        HashMap<String,ArrayList<Integer>> players = new HashMap<>();
        players.put("player1",new ArrayList<Integer>());
        players.put("player2",new ArrayList<Integer>());
        players.put("player3",new ArrayList<Integer>());
        players.put("card",new ArrayList<Integer>());
        for  (int x = 1; x <= list.size(); x++) {
            if(list.size()-x<=2){
                players.get("card").add(list.get(x-1));
            }else if(x%3==0){
                players.get("player1").add(list.get(x-1));
                players.get("player2").add(list.get(x-2));
                players.get("player3").add(list.get(x-3));
            }
        }
        return players;
    }

    // 将玩家的手牌展示
    public static void pokerShow(ArrayList<Integer> list, HashMap<Integer, String> poker, String player ){
        // 手牌排序
        Collections.sort(list);

        StringBuilder show = new StringBuilder();
        show.append(player).append(":  ");
        for (Integer integer : list) {
            show.append(poker.get(integer)).append(" ");
        }
        System.out.println(show);
    }

}


