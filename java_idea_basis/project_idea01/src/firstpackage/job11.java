package firstpackage;

/**
 * java 继承带来多态的体现
 * 概念:
 *      一类事物的多种形态
 * 前提:
 *      必须要有子父类关系(可以继承也可以实现)
 *      要有方法的重写(没有方法的重写, 没有意义)
 *      必须有父类引用指向子类对象
 * 优点:
 *      1. 消除类型之间的耦合关系
 *      2. 可替换性
 *      3. 可扩充性
 *      4. 接口性
 *      5. 灵活性
 *      6. 简化性
 * 父类借助子类的扩展 ,有了同一类型下无穷无尽的可能,正如人与人之间的各种同与不同
 *
 * 特点:
 *      成员变量的使用:  编译看左边, 运行也看左边 (编译和运行都使用父类)
 *      成员方法的使用:  编译看左边, 运行看 右边(编译父类, 运行的是子类)
 *      父类在构建多态时只能使用自身已有成员(方法与变量)
 *      父类可以使用被子类重写过的成员方法, 但是不能使用被重写后的重载方法
 *      父类不能访问子类的成员变量(即使同名)
 *  一些小问题:
 *      父类的引用不能直接访问子类特有的属性和行为
 *              向上转型:  当使用多态的父类引用指向子类对象时, 将子类对象的类型转换成父类类型
 *              向下转型:  强转的格式:  ((子类类型) 父类引用)  强转都需注意安全
 *
 */
public class job11 {
    public static void main(String[] args) {
        // 父类引用子类 并使用了子类重写父类抽象方法后的子类方法 (这种引用默认向上转型)
        System.out.println("父类引用子类_______________________________");
        Pen pen1 = new Brush(12.34,"黄色","画笔");
        pen1.write();
        System.out.println(pen1.producer);
        pen1.show();
        pen1.show2();
        /*
        pen1.show2("想使用儿子的重载");
        */
        // pen1.fun();  无法访问子类独有的
        // 对象间的简单交互
        System.out.println("对象简单交互_______________________________");
        Pen pen2 = new Pencli(28,"黑色","铅笔");
        Painter painter = new Painter("齐白石");
        painter.draw(pen2);

        // 向下转型  原先创建的对象 向下转型
        System.out.println("父类向下转型_______________________________");
        Brush brush =(Brush) pen1;
        System.out.println(brush.producer);
        brush.fun();
        brush.show2();
        brush.show2("爸爸刚才想用我的重载 我不给用");
        /*
        //
        虽然编译不会报错 但是运行的时候会有很多问题
        因为父类对象声明时没有引用这个子类
        Pencli pencli = (Pencli)pen1;

        声明时压根没有引用子类
        Pen pen3 = new Pen(15,"蓝色","眉笔");
        Brush brush2 = (Brush)pen3;
        */



    }
}

interface WriteAction{
    void write();
}

class Pen implements WriteAction{
    private double price;
    private String color;
    private String type;
    String producer = "浙江皮革厂";

    public Pen() {

    }

    public Pen(double price, String color, String type) {
        this.price = price;
        this.color = color;
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public void write() {

    }

    void show(){
        System.out.println("我是父类 等我儿子重写");
    }

    void show2(){
        System.out.println("爸爸还是等儿子重写 并且还要试试我儿子能重载不");
    }

}

class Brush extends Pen{
    String producer = "江南皮革厂";

    public Brush() {
    }

    public Brush(double price, String color, String type){
        super(price, color, type);
    }

    @Override
    public void write() {
        System.out.println("现在使用的是价格为: "+ super.getPrice() +", 颜色是: "+ super.getColor()
                            + ", 类型是: "+ getType());
    }

    void fun(){
        System.out.println("这个方法我爸爸可没有!!");
    }

    @Override
    void show() {
        System.out.println("我是子类 重写了我爸爸 我爸爸还要我的生产商信息:" + producer );
    }

    @Override
    void show2() {
        System.out.println("我爸爸又要我干体力活 重写它的show2");
    }

    void show2(String str){
        System.out.println("爸爸说 不仅要重写 还要重载!!" + str);
    }
}

/**
 * 铅笔类
 */
class Pencli extends Pen{
    String producer = "温州皮革厂";
    public Pencli() {
    }

    public Pencli(double price, String color, String type){
        super(price, color, type);
    }

    @Override
    public void write() {
        System.out.println("现在使用的是价格为: "+ super.getPrice() +", 颜色是: "+ super.getColor()
                + ", 类型是: "+ getType());
    }
}

/**
 * 画家 执笔人
 */
class Painter{
    private String name;
    public Painter() {
    }

    public Painter(String name) {
        this.name = name;
    }

    void draw(Pen p){
        System.out.println("画家" + name + "正在使用" + p.getType()+"画画, "
                            +"这支笔颜料考究, 是淡淡的"+p.getColor()+", 它原来的价格是" +
                p.getPrice()+", 但以后不知道会翻多少倍!");
    }
}