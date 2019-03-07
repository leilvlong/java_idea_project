package firstpackage;

/**
 * 接口的内部类
 *      与内部类的引用声明不同 格式为:
 *          接口.内部类 引用变量名 = new 接口.内部类
 */
public class job13 {
    public static void main(String[] args) {
        // 为了区分 内部类的方法与外部接口同名  但是内部类的开头带有In
        // 创建外部接口的内部类的引用对象 使用内部类的方法(内部类的方法中调用了外部接口的方法)
        OutInterface.Inner inner = new OutInterface.Inner();
        inner.fun();
        inner.InStaticFun();
        inner.InDefaultFun();
        inner.InPrivateStaticFun();
        inner.InPrivateFun();

        // 外部接口的内部类直接使用外部接口的方法 被注释的都不能用
        System.out.println("内部类的引用变量对象直接使用接口的成员___________________________");
        System.out.println(inner.name);
        //inner.staticFun();
        inner.defaultFun();
        //inner.privateStaticFun();
        //inner.privateFun()
        // 至于抽象方法被重写了

    }
}



interface OutInterface{
    // 外部接口常量
    String name= "  外部接口";

    // 外部接口抽象方法
    void fun();

    // 外部接口静态方法
    static void staticFun(){
        System.out.println("    接口的静态方法");
    }

    // 外部接口默认方法
    default void defaultFun(){
        System.out.println("    接口的默认方法");
    }

    // 外部接口的私有静态方法
    private static void privateStaticFun(){
        System.out.println("    私有的接口静态方法");
    }

    //外部接口的私有方法
    private void privateFun(){
        System.out.println("    私有的接口普通方法");
    }

    // 内部类也可以实现接口
    class Inner implements OutInterface{
        // 实现外部接口的抽象方法
        @Override
        public void fun(){
            System.out.println("内部类实现外部接口的抽象方法");
        }

        // 内部类方法调用外部接口静态方法
        public void InStaticFun(){
            System.out.println("我是内部类,调用接口的静态方法:");
            staticFun();
        }

        // 内部类方法调用外部接口默认方法
        public void InDefaultFun(){
            System.out.println("我是内部类,调用接口的默认方法:");
            defaultFun();
        }

        // 内部类调用外部接口私有静态方法
        public void InPrivateStaticFun(){
            System.out.println("我是内部类,调用接口的私有静态方法:");
            privateStaticFun();
        }

        // 内部类调用外部接口私有方法
        public void InPrivateFun(){
            System.out.println("我是内部类,调用接口的私有普通方法失败 调用接口的常量:");
            /* 不可以使用
            privateFun();
            OutInterface.privateFun();
            */
            System.out.println(name);
        }
    }
}