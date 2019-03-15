package firstpackage;
/*
有趣的现象  对int 静态变量进行自增时  如果在一个main中运行
这种自增是会改变接下来的其它调用的初始值的

 */
public class job18 {
    public static void main(String[] args) {
        staticFun();
        staticFun2();
        Fun1 fun1 = new Fun1();
        Fun2 fun2 = new Fun2();
        fun1.fun();
        fun2.fun();
    }

    public static void staticFun(){
        int num1 = Fun.x++;
        int num2 = Fun.x++;
        int num3 = Fun.x++;
        int num4 = Fun.x++;
        System.out.println(num1);
        System.out.println(num2);
        System.out.println(num3);
        System.out.println(num4);
        Fun fun = new Fun();
        System.out.println(fun);
    }

    public static void staticFun2(){
        Fun fun = new Fun();
        System.out.println(fun);
    }
}


class Fun{
    static int x=10;

    @Override
    public String toString() {
        return "Fun x: "+x;
    }
}

class Fun1{
    public void fun(){
        Fun.x++;
        Fun.x++;
        System.out.println(Fun.x);
    }
}

class Fun2{
    public void fun(){
        Fun.x++;
        Fun.x++;
        System.out.println(Fun.x);
    }
}