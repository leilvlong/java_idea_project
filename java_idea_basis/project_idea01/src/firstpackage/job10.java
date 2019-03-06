package firstpackage;


/**
 * java接口丶继承丶多态
 * 1.多个接口中, 出现了同名的抽象方法, 只需要重写一次
 * 2.多个接口中, 出现了同名的默认方法, 必须重写这个同名的方法
 * 3.多个接口中,出现了方法参数不同的默认方法时可不重写(传入参数类型不同会区分) 与返回值无关
 * 4.静态方法不能被实现的类拿来使用
 *     援引贴吧大神的解释:
 *         所有的抽象类，接口，普通类的static方法都不能被子类调用。
 *         凡是被static修饰的成员方法和成员变量都属于这个类的，
 *         不属于这个类的任何一个实例。子类继承不到也实现不了父类或接口的静态方法，
 *         子类写一个跟父类一样的静态方法（或子接口写一个父接口一样的静态方法）都不属于方法重写，
 *         而是属于子类本身的方法。再者，如果一个类实现两个接口，两接口都有同样的静态方法，
 *         这个实现类自己也有跟接口一样的方法，这样是不会有事的；
 *         但是，如果两个接口有同样的默认方法，那么这个类必须要重写接口的默认方法，不然会出现编译错误。
 *  5. 静态会随着类的加载而加载, 优先于对象存在
 *  6. 静态方法只能由静态方法调用,但是静态变量可以被类共享
 *  7. 使用静态方法只需 class.method 或者 接口.method,类的静态变量只能在类中,
 *     接口中只有被final修饰的不可改变的常量,可以被继承者使用
 *  8. 接口多继承同名时只需重写默认方法 ,抽象方法不用重写
 *  9. 继承多个接口抽象方法同名且参数不同时实现类一一必须重写
 */

class job10{
    public static void main(String[] args) {
        Realize1 realize1 = new Realize1();
        realize1.baseFun();
        realize1.abstractFun();
        realize1.defaultFun();
        realize1.fun2();
        // 来自三个不同的接口 参数不同而已
        realize1.defaultFun1("1");
        realize1.defaultFun1(1);
        realize1.defaultFun1(1.0);
        realize1.fun();
        // 调用接口静态方法
        Port1.staticFun();
        Port1.staticFun1("1");

        System.out.println("新的子类 新的接口实现________");
        Realize2 realize2 = new Realize2();
        // 上面能用的下面都能用
        realize2.baseFun();
        realize2.abstractFun();
        realize2.defaultFun();
        realize2.fun2();
        // 来自三个不同的接口 参数不同而已
        realize2.defaultFun1("1");
        realize2.defaultFun1(1);
        realize2.defaultFun1(1.0);
        realize2.fun();

    }
}

/**
 * 接口1
 */
interface Port1{
    // 接口的常量 默认有final修饰
    String name="zhang";

    // 接口的抽象方法 默认有 public abstract修饰
    void abstractFun();

    //接口的无参默认方法 默认有 public修饰
    default void defaultFun(){
        System.out.println("与接口23同名");
    }
    // 接口的有参默认方法 默认有 public 修饰
    default int defaultFun1(String num){
        System.out.println("接口1的字符串参数 默认方法: "+ num  + "  ");
        return Integer.parseInt(num);
    }
    //接口的无参静态方法 默认有 public修饰
    static void staticFun(){
        System.out.println("接口1的无参静态方法");
    }
    //接口的有参静态方法 默认有 public修饰
    static void staticFun1(String num){
        System.out.println("接口1的有参静态方法: " +num );
    }
    // 接口的私有静态方法
    private static void privateStaticFun(){
        System.out.println("接口1的私有静态方法");
    }

    // 接口的普通私有方法
    private void privateDefaultFun1(){
        System.out.println("接口1的普通私有方法");
    }
}

/**
 * 接口2
 */
interface Port2{
    void abstractFun();

    default void defaultFun(){
        System.out.println("与接口13同名");
    }

    default int defaultFun1(int num){
        System.out.println("接口2的int参数 默认方法: "+ num );
        return num;
    }

    static void staticFun(){
        System.out.println("接口2的无参静态方法");
    }
    static void staticFun(String num){
        System.out.println("接口2的有参静态方法: " +num );
    }

    void fun2();
}

/**
 * 接口3
 */
interface Port3{
    void abstractFun();

    default void defaultFun(){
        System.out.println("与接口12同名");
    }

    default double defaultFun1(double num){
        System.out.println("接口3的double参数 默认方法: "+ num );
        return num;
    }

    static void staticFun(){
        System.out.println("接口3的无参静态方法");
    }
    static void staticFun(String num){
        System.out.println("接口3的有参静态方法: " +num );
    }
    void fun2();

}

/**
 * 继承接口123
 */
interface Ptot4 extends Port1,Port2,Port3{
    @Override
    default void defaultFun() {

    }
}

/**
 * 基类
 */
abstract class BaseClass{
    private String name;
    int age;
    abstract void baseFun();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

/**
 * 子类 继承基类
 * 实现接口123
 */
class Realize1 extends BaseClass implements Port1, Port2, Port3{
    static String name;

    @Override
    public void abstractFun() {
        System.out.println("我必须重写接口的抽象方法");
    }

    @Override
    public void fun2() {
        System.out.println("接口2的新抽象方法");
    }

    @Override
    public void defaultFun() {
        System.out.print("接口默认方法同名 必须重写 ");
        System.out.println("我是用了接口1的常量: "+ Port1.name);
    }

    @Override
    void baseFun() {
        System.out.println("我必须重写基类的抽象方法");
    }

    public void fun(){
        System.out.println(Port1.name);
    }
}

/*
子类 继承BaseClass
实现 Prot4
 */
class Realize2 extends BaseClass implements Ptot4{

    @Override
    void baseFun() {
        System.out.println("我必须重写父类的抽象方法");
    }

    @Override
    public void abstractFun() {
        System.out.println("实现接口4 ,接口4抽象方法继承接口1(23)");
    }
    @Override
    public void fun2(){
        System.out.println("实现接口2的抽象方法");
    }

    public void fun(){
        System.out.println(name);
    }
}