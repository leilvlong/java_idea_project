package firstpackage;

/**
 * 抽象类的定义:
 *      父类中的方法，被它的子类们重写，子类各自的实现都不尽相同。那么父类的方法声明和方法主体，
 *      只有声明还有意义，而方法主体则没有存在的意义了。我们把没有方法主体的方法称为抽象方法。
 *      Java语法规定，包含抽象方法的类就是抽象类。
 */

public class job07 {
    public static void main(String[] args) {
        /*
        抽象类不能创建对象
        AbstractBase abstractBase= new AbstractBase();
        */
    }
}

abstract class AbstractBase{
    public abstract String getName();
    public abstract void setName();
    public abstract String getGender();
    public abstract void setGender();
    public abstract int getAge();
    public abstract void setAge();
}

class InheritAbstractBase extends AbstractBase{
    private String name;
    private String gender;
    private int  age;

    public String getName(){
         return name;
    }

    public void setName(){
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(){

    }
    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(){

    }
    public void setAge(int age) {
        this.age = age;
    }
}
