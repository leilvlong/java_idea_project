package firstpackage;
/*
lambda 表达式示例
虽然不那么面向,且使用起来诸多限制:
    如接口只能有一个抽象方法
但是比较优雅:
    ()->就可以代替整个匿名内部类
 */
public class job16 {
    public static void main(String[] args) {
        int[] ints = {1,2,3,4};
        System.out.println("lambda表达式________________________");
        int sum1 = fun1(ints,ints1 ->{
            int sum=0;
            for (int i : ints1) {
                sum+=i;
            }
            return sum;
        } );
        System.out.println(sum1);
        System.out.println();

        System.out.println("接口的内部类实现抽象方法________________");
        int sum2 = fun2(ints);
        System.out.println(sum2);
        System.out.println();

        System.out.println("匿名内部类_________________");
        int sum3 = fun3(ints, new Interf() {
            @Override
            public int sumArrar(int[] ints) {
                int sum = 0;
                for (int anInt : ints) {
                    sum+=anInt;
                }
                return sum;
            }
        });
        System.out.println(sum3);

    }

    public static int fun1(int[] ints,Interf interf){
        return interf.sumArrar(ints);
    }

    public static int fun2(int[] ints){
        Interf.Sum sum=new Interf.Sum();
        return sum.sumArrar(ints);
    }

    public static int fun3(int[] ints, Interf interf){
        return interf.sumArrar(ints);

    }
}

interface Interf{
    int sumArrar(int[] ints);

    class Sum implements Interf{

        @Override
        public int sumArrar(int[] ints) {
            int sum = 0;
            for (int anInt : ints) {
                sum+=anInt;
            }
            return sum;
        }
    }
}