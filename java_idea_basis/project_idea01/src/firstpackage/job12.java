package firstpackage;

/**final修饰符:
 *      修饰类:
 *          不能被继承
 *      修饰方法:
 *          不能被重写
 *      修饰变量:
 *          就变成了常量, 值不能修改
 *      成员变量:
 *          可以直接赋值
 *          可以先声明, 然后再构造方法中赋值
 *      局部变量:
 *          可以声明并赋值, 也可以先声明并赋值
 * 就不一一举例了 挺好理解的
 *
 *内部类(匿名内部类):
 *      内部类使用外部类中的内容, 可以直接使用
 *          但是当外部类的实例变量名与内部类的实例变量名相同时会采用优先原则
 *          无法通过this关键字使用同名的外部类的实例变量,但是可以使用内部类的
 *          同名实例变量  this关键字表示 代表本身 外部类则出了内部类这个本身
 *      外部类使用内部类中的内容, 需要先创建对象
 *      匿名内部类的前提是:
 *          必须存在一个类或者接口
 *      格式  new 接口名/类名() {方法内容}
 */
public class job12 {
    public static void main(String[] args) {
        /*
        内部类的简单使用:
            External.Inward inward = new External().new Inward();
            inward.showName("李四");
            External external = new External();
            external.show();
        */

        // 匿名内部类
        /*
        正常的使用方式:
            实现接口的子类对象传入参数中
            Anonymity anonymity = new Anonymity();
            anonymity.showAnonymity(new Realize());
            anonymity.displayAnonymity(new Realize(),"干什么");
            分析:
                new Realize 实际是Interface的实现类
        */

        Anonymity anonymity = new Anonymity();
        // 在参数里面直接传入Interface 这个接口 然后将其抽象方法全部重写
        // 其实际为 new Interface {对Interface方法的实现,从代码结构可以看到同实现类的结构是一样的}
        anonymity.showAnonymity(new Interface() {
            @Override
            public void fun1() {
                System.out.println("匿名函数的fun1方法");
                fun3();
            }

            @Override
            public String fun2(String str) {
                System.out.println("匿名函数的fun2方法传入的字符串参数: "+ str);
                return str;
            }
            /*
            提示内部类不能有静态声明
            static void staticfun(){
                System.out.println();
            }
            */
            void fun3(){
                //虽然可以这样写 也不会报错 接口不知道内部类这样做了
                // 不可以通过接口使用 但是可以在内部内中使用
                System.out.println("这是我在内部类中写的fun3, 我现在推测可以通过内部类实现接口 我去试试");
            }

        });
        // 可以看到 接口有多个抽象方法时这样很麻烦 实际使用时需要根据场景灵活使用
        anonymity.displayAnonymity(new Interface() {
            @Override
            public void fun1() {
                System.out.println("匿名函数的fun1方法");
            }

            @Override
            public String fun2(String str) {
                System.out.println("匿名函数的fun2方法传入的字符串参数: "+ str);
                return str;
            }
        },"可以看到,这样很麻烦");
    }
}


interface Interface{
    void fun1();

    String fun2(String str);
}

class Realize implements Interface{
    @Override
    public void fun1(){
        System.out.println("我实现了接口Interface的抽象方法 fun1()");
    }

    @Override
    public String fun2(String str){
        System.out.println("我实现了接口Interface的抽象方法 fun2()");
        System.out.println("我输出传入方法的String参数: "+str +
                "\n"+"并且我将这个参数原封不动的返回");
        return str;
    }


}

/**
 * 写两个方法 一个带参 一个不带参
 * 传入的都是接口 Interface
 */
class Anonymity{
    public void showAnonymity(Interface inter){
        inter.fun1();
    }

    public void displayAnonymity(Interface inter, String str){
        inter.fun2(str);
    }

}

/**
 * 正常的内部类
 */
class External{
    String name = "李二";

    public void show(){
        Inward inward = new Inward();
        inward.showName("张麻子");
        System.out.println(name);
        System.out.println(inward.name);
    }

    /**
     * 内部类
     */
    class Inward{
        String name = "王二";
        public void showName(String name){
            System.out.println(name);
            System.out.println(this.name);
        }
    }
}


