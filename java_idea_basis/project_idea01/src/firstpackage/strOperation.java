package firstpackage;

import java.util.ArrayList;
import java.util.Random;

public class strOperation {
    public static void main(String[] args) {
        forListStr();

    }

    public static void forListStr(){
        /*
        定义ArrayList，存入多个字符串
        ArrayList 中的字符串如果包含某个指定字符串则删除
        然后遍历 ArrayList 元素并输出
         */

        // 如果包含这个字符串则删除,可以以参数的方式传入 这样写方便测试
        String strin = "abdef";
//        String strin = "bdef";
//        String strin = "def";
//        String strin = "ef";
//        String strin = "f";

        // 字符串 ArrayList也可以以参数的方式传入
        ArrayList<String> strlist = new ArrayList<>();
        /*
        不想手动往 strlist 添加元素  我可以使用Char对应的ASCLL码表
        将数字转为char对应的字母 然后拼接 添加到 strlist 中去
        首先去查一下char对应的字母的取值范围
        然后通过这个范围的随机数来生成添加
        */
        // 往strlist添加字符串的操作
        for (; strlist.size() < 10; ) {
            String str ="";
            for (int x = 0; x < 5; x++) {
                char cha = (char) (new Random().nextInt(26) + 97);
                str = str.concat(String.valueOf(cha));
            }
            strlist.add(str);
        }

        // 添加一下测试用来删除的字符串
        strlist.add("abdef");
        strlist.add("abdef");
        strlist.add(0,"abdef");
        strlist.add(6,"abdef");
        strlist.add(6,"abdef");
        System.out.println(strlist.toString());

        // String.contains()方法可以轻易做到
        // 对strlist中如果某个字符串包含指定字符串的删除 自己实现的过程
        for(int x=0; x<strlist.size(); x++){

            // 处理 strlistz中的的每个字符串 添加到 ArratList<Character>中
            ArrayList<Character> charac = new ArrayList<>();
            String str = strlist.get(x);
            for(int y=0; y<str.length(); y++){
                char cha = str.charAt(y);
                charac.add(cha);
            }
            /*
                char 数组容器也可以 但我选择全部自己实现
                char[] charac = strlist.get(x).toCharArray();
             */
            /*
            上面已将将字符串处理为 ArrayList<Character>
            我只需要将里面的每个字符按照规则组合成字符串
            组合规则为:
                获取传入参数字符串的长度
                从0开始索引  到参数字符串长度-1
                组合成长度相同的字符
                将其与传入的参数字符串做比较 如果相同 则删除
                然后从1开始 到参数字符串长度
                组合成长度相同的字符
                将其与传入的参数字符串做比较 如果相同 则删除
                以此类推 但不能超过 ArrayList<Character>.size()
             因此需要 ArrayList<Character>.size() - 当前索引>0
             */
            for(int z=0; z<charac.size(); z++){
                int strLength = strin.length()+z;
                int num = z;
                String compareStr = "";
                // 保证索引与需要组合的字符串长度能保持一致
                while (num <strLength ) {
                    if ( charac.size()-num>0) {
                        compareStr = compareStr.concat(String.valueOf(charac.get(num)));
                    }else{
                        break;
                    }
                    num++;
                }
                /*如果指定组合字符串与传入字符串相同 删除当前字符串
                   因为删除ArrayList ArrayList.size会减少1
                   下一个元素会占据当前索引跳过遍历 所以索引应当自减
                 */
                if (strin.equals(compareStr)) {
                    strlist.remove(strlist.get(x));
                    x--;
                }
            }
        }
        System.out.println(strlist.toString());
    }
}
