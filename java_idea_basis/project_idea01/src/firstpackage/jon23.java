package firstpackage;
/*
java的异常处理:
    1.自定义异常 继承Exception 重写构造方法
    2.一个方法可能抛出异常 则 使用 throws + 对应的异常 (与方法同列)
    3. try catch finly 处理异常 最常用:
        try 捕捉执行的代码块是否有异常 若捕捉到 则后面的代码不再执行
        catch 捕捉到异常后的逻辑处理
        finally  一定会执行  一般用于资源回收
为什么会有异常处理:
    开发过程中难免会遇到各种奇奇怪怪的问题,或是系统原因导致的
    或是开发人员某个细节未注意导致的,涉及到系统原因导致的重大错误
    一般开发人员无法解决,只能尽量避免,而开发过程中导致的异常在所难免
    当我们不做异常处理时,jvm虚拟机则会做默认处理,将异常信息打印在控制台,
    并挂掉程序,如果因为一个小原因挂掉程序无疑很蠢,因此 ,在可能出现异常的
    代码块中做一层保险使程序更为健壮,同时也可以通过错误日志捕捉异常的原因
    修改代码使程序更有质量
适配器设计模式 :
    一个借口的多个抽象方法不会适用于所有实现的子类
    这时可以以一个抽象类去实现该接口的所有抽象方法 而不写方法体
    后续的继承该抽象类重写方法即可

 */
public class jon23 {
    public static void main(String[] args) {
        tryCatch();
    }

    public static void tryCatch(){
        try{
            System.out.println(10/0);
        }catch (Exception e){
            throw e;
        }
        System.out.println("aa");
    }
}
