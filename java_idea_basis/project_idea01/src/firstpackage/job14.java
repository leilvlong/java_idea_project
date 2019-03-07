package firstpackage;

/**
 * 与接口有些许的不同 在类中的内部类可以随意使用除了构造方法外的所有成员
 * 内部类属于外部类的 方法与实例变量同级的成员 ,但是外部类使用内部类时需要创建对象
 * 内部类不能有静态声明
 */


public class job14 {
    public static void main(String[] args) {
        /*
        OutClass.Inner inner = new OutClass().new Inner();
        inner.InOutClass(18,"张三");
        //也可以这样
        OutClass.Inner inner2 = new OutClass(20,"李四").new Inner();
        inner2.InOutClass2();
        */

        OutClass out = new OutClass();
        // 外部类写的方法里new了内部类然后使用内部类的的方法
        // 而内部类的方法里又调用了外部类的方法
        out.newInner();

        OutClass out2 = new OutClass(89,"老人");
        out2.newInner2();


    }
}


class OutClass{
    private int  age;
    static String name;

    public OutClass(){

    }
    public OutClass(int age,String name) {
        this.age = age;
        this.name = name;
    }

    public void publicFun(){
        System.out.println("OutClass的publicFun方法");
    }

    private void privateFun(){
        System.out.println("Outclass的privateFun方法");
    }

    public static void staticFun(){
        System.out.println("OutClass的staticFun方法");
    }

    public void newInner(){
        // 外部类要使用内部类的成员 必须要声明并new一个对象
        Inner inner = new Inner();
        // 私有成员可以访问
        inner.InprivaterFun();
        // 方法可以正常使用
        inner.InOutClass(19,"王二");
        // 不可以拥有静态成员
    }

    public void newInner2(){
        Inner inner = new Inner();
        inner.InOutClass2();
    }

    /*
        firstpackage.OutClass.this' cannot be referenced from a static context
        翻译: 这不能从静态上下文中引用
        静态的加载随类的加载而加载 成员是随着对象的加载而加载
        public static void newInner2(){
        Inner inner = new Inner();
        inner.InOutClass2();
         }
    */


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Outclass的内部类
    class Inner{
        // 写一个方法 调用外部类的构造方法
        public void InOutClass(int age, String name){
            // 构造方法无法直接调用,需要new  getter与setter随意
            // OutClass(age,name)
            setAge(age);
            System.out.println(getAge());
            // 普通方法可以使用
            publicFun();
            //静态方法
            staticFun();
            // 私有方法可以调用
            privateFun();
            // 实例变量随便使用
            System.out.println(age+"    "+name);
        }

        public void InOutClass2(){
            System.out.println(getAge());
            // 普通方法可以使用
            publicFun();
            //静态方法
            staticFun();
            // 私有方法可以调用
            privateFun();
            // 实例变量随便使用
            System.out.println(age+"    "+name);
        }

        private void InprivaterFun(){
            System.out.println("内部类的私有方法");
        }


    }
}