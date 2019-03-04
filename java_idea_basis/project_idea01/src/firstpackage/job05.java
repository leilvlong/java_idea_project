package firstpackage;

/*
java 面向对象之继承总结:
    1. private 属性除非有什么特殊原因  最好开放setter与getter
    2. 子类继承基类创建对象时会初始化基类(多重继承也适用)
    3.this表示本类 super可以得到父类(基类)的属性与方法 但仅限可以访问的
    4.子类可以重写父类的方法,可以动态的扩展需要自己的功能(方法体内容不同)
        1. 子类方法覆盖父类方法，必须要保证权限大于等于父类权限。
        2. 子类方法覆盖父类方法，返回值类型、函数名和参数列表都要一模一样。
    5.最好不要覆盖基类(父类)的 属性 以及基类(父类)的setter与getter方法 主要是因为很蠢
    6.继承可以添加额外的属性与方法(多态的呈现 大概是这样来的把)
    7.子类创建对象时父类会被初始化是因为子类的构造方法默认带 super() (java所有的类都默认带有)
    8.子类继承父类的所有非私有成员,但不包括构造方法 但子类可以通过 super()初始化父类;
目前暂时就这么多
 */


public class job05 {
    /*
    启动测试继承的类创建的对象
     */
    public static void main(String[] args) {
        // 创建子类继承基类的对象
        //SubClass1 sub1= new SubClass1();
        /*
            得到输出:
                这是无参的基类构造方法,测试是否与子类创建对象时是否会初始化基类
                这是子类1的构造方法,测试是否会初始化基类
            得到结论:
                子类会初始化基类 但是子类与基类不共享构造方法以及构造方法的参数传递
            例子:
                SubClass1 sub1_1 = new SubClass1("男","铁匠");
            会报错:
                java: 无法将类 firstpackage.SubClass1中的构造器 SubClass1应用到给定类型;
                需要: 没有参数
                找到: java.lang.String,java.lang.String
                原因: 实际参数列表和形式参数列表长度不同
            注意; 子类无法调用基类的私有属性与方法
         */

        //SubClass2 sub2 = new SubClass2("女","会计","刘芳",27);
        //sub2.printMessage();
        /*
        在这个输出信息方法中 我调用了重写过的基类的一个方法 输出的为子类的
        当重写基类方法后 需要使用时 需要: super.method()
         */

        /*
         java不支持多继承 但支持多重继承
        可以在子类的构造方法中使用 super() 来使用基类的构造方法
        */

        SubClass3 sub3 = new SubClass3("男","铁匠","赵铁柱",38,10053.8);
        sub3.printMassage();
        /*
        SubClass3 sub3_3 = new SubClass3();
        假设这种方式直接初始化
        可以直接使用getter与setter设置基类与爷爷类与自己的 private 属性
        因此 重写方法时 1. 不应重写getter与setter
                        2. 子类不应覆盖基类的属性
                        如果非要这样做 要么是不得已 要么是蠢爆了
                        但我还是写个这样的例子看看

        */
    }
}

/**
 * 本类作为我了解java继承的一些基本特性的基类
 */

class SuperClass{
    /**
     * 基类有属性如下:
     *      种族(私有 不开放setter,开放getter  不参与构造)
     *      性别(参与构造 会有私有方法判断是否合法,开放setter与getter)
     *      职业(参与构造 开放setter与gettter)
     */
    private String race = "people";
    private String gender;
    String profession;

    /**
     * 无参构造方法
     *      当基类与继承的子类 subclass1 都无参时
     */
    SuperClass(){
        System.out.println("这是无参的基类构造方法,测试是否与子类创建对象时是否会初始化基类");
    }

    SuperClass(String gender, String profession){
        if(genderVerify(profession)){
            this.gender =gender;
        }else{
            System.out.println("性别设置失败 无效输入");
        }
        this.gender = gender;
    }

    public String getRace(){
        //返回种族
        return race;
    }

    public String getGender(){
        // 返回性别
        return gender;
    }

    public void setGender(String gender){
        // 修改性别
        if(genderVerify(gender)){
            this.gender = gender;
        }else{
            System.out.println("性别设置失败 无效输入");
        }
    }

    public void setProfession(String profession){
        // 修改职业
        this.profession = profession;
    }

    public String getProfession(){
        // 返回职业
        return profession;
    }

    private boolean genderVerify(String sex){
        if(sex == "男"){
            return true;
        }else if(sex == "女"){
            return true;
        }else{
            return false;
        }
    }

    public void lifeLand(){
        System.out.println("人类的足迹遍布地球的每一块陆地");
    }

}


class SubClass1 extends SuperClass{
    SubClass1(){
        //  无参构造默认带有 super()  创建对象时会初始化父类
        System.out.println("这是子类1的构造方法,测试是否会初始化基类");
    }

    // 尝试重写基类构造方法
    /*
    报错无效的方法声明
    SuperClass(){

    }
    */
}

// 继承可以添加额外的方法 与属性
class SubClass2 extends SuperClass{
    private String gender;
    String name;
    int age;
    SubClass2(){
        System.out.println("这是子类2的初始化方法, 测试是否会被我儿子继承");
    }
    SubClass2(String name, int age, String gender){
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
    SubClass2(String gender, String profession, String name, int age ){
        // 非私有 可以调用
        super.setGender(gender);
        super.profession = profession;
        this.name = name;
        this.age =age;

        // 可以通过super.setter设置 不可以直接得到

    }

    public void printMessage(){
        System.out.println(super.getRace());
        System.out.println(super.getGender());
        System.out.println(super.getProfession());
        System.out.println(name);
        System.out.println(age);
        super.lifeLand();


    }

    public void lifeLand(){
        System.out.println(name + "生活在中国");
    }

    public void setGender(String gender){
        this.gender = gender;
    }

    public String getGender(){
        return gender;
    }

}

class SubClass3 extends SubClass2{
    double deposit;
    SubClass3(String gender, String profession, String name, int age,double deposit){
        // 当使用super()时  必须是构造函数体中的第一个语句
        // 不知道是不是我使用方式有问题 super() 往里面传参时只能找到爸爸类 找不到爷爷类
        // 多重继承创建对象时 子类的基类会被初始化 但是所继承的基类不会
        super(name,age,gender);
        super.setGender(gender);
        super.setProfession(profession);
        this.deposit = deposit;

    }

    public void printMassage(){
        System.out.println(super.getRace());
        System.out.println(super.getGender());
        System.out.println(super.name);
        System.out.println(super.profession);
        System.out.println(super.age);
        System.out.println(deposit);
        super.lifeLand();
    }

}


