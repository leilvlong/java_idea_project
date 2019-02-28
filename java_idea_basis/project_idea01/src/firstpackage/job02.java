package firstpackage;

import java.util.Arrays;

/*
当时使用idea开始学习java第一件要做的事就是讲字符编码格式改为utf-8
 */
/*
java 封装:
    封装的基本原则就是将实例变量标记为私有(private).
    大部分的实例变量都有一个适当的范围,而暴露的实例
    变量可以被随意修改,程序运行时可能会造成各种难以
    想象的灾难;
    封装会对实例变量加上绝对领域,确保实例变量数据的
    合法性与安全性
    当想要访问该对象的实例变量时,强迫其通过setter与
    getter,将不合理的操作退回


 */
public class job02 {
    public static void main(String[] args){
        Dog d = new Dog();
			/*
			抛出异常 访问控制
				d.size = 10;
			*/

		/*
		不要忘记 对象的属性(对象本身已知的事物)叫实例变量
		对象的行为叫方法
		 */
        d.setSize(70);
        d.setName("rui");
        d.bark();
        System.out.println(d.getSize());
        System.out.println(d.getName());

        // 新建一个对象 不传参数 获取他们会是什么呢
        Dog f = new Dog();
        System.out.println(f.getSize());
        System.out.println(f.getName());
        System.out.println(f.getList());

			/*
			int默认为 0
			String 默认为null
			int[] 默认为null
			局部变量的声明是没有默认值的 这是它们的区别
			方法的参数基本与局部变量相同,都是在方法中声明(准确来说是参数列声明)
			但参数并没有声明的问题,如果调用方法而没有传入参数就会会抛出异常,不存在初始化问题
			声明的局部变量则是如果调用时没有初始化就会抛出异常
			引用变量也可以用来比较他们的引用(字节)是否相同
			忽然想到:
			    除了对数据容量大小的优化外,避免无谓的引用变量与对象也是对内存的极大优化
			*/
			/*
			数组目前总结到的定义方式
            int[] si =  new int[]{1,2,3};
            int[] sii = new int[3];
            int[] siii = {1,2,3};
            */
        Dog g = new Dog();
        g.setSize(2);
        g.setName("line");
        g.setList(new int[]{1, 2, 3});
        g.printInstanceVariable();
        /*
        无法访问 只能在原类中使用
        g.priveteMethod()
         */
        // 数组翻转
        f.arrayReversal(new int[]{1, 2, 3,4,5,6,7,8,9});

        /*非main方法 除了创建对象使用类方法
         只能使用私有方法
         非main方法 除了创建对象调用方法外只能使用私有本类的私有方法
         */

        //无参构造
        Cat cat = new Cat();
        // 有参构造
        Cat cat1 = new Cat("小明");
    }
}


class Dog{
    // java封装
    // 私有的 我只允许只能通过方法获取
    // 甚至不允许访问
    private int size;
    private String name;
    private int[] list;
    public int getSize(){
        return size;
    }

    public void setSize(int s){
        size = s;
    }

    public String getName(){
        return name;
    }

	/*
	貌似没什么问题 但是需要注意的是这里的形参与实例变量同名
	传入实参时是传不进来的  java的就近原则
	需要使用关键字this
	this:
	    谁来调用我 我就代表谁 可以用来区分成员变量与实际变量
	public void setName(String name){
		name = name;
	}
	*/

    public void setName(String name){
        this.name = name;
    }

    public int[] getList(){
        return list;
    }

    public void setList(int[] lis){
        list = lis;
    }

    void printInstanceVariable(){
        privateMethod();
    }

    void bark(){
        if(size>60){
            System.out.println(name + " in woff!! woff!!");
        }else if(size>14){
            System.out.println(name + " in ruff!! ruff!!");
        }else{
            System.out.println(name + " in Yip!!   Yip!!");
        }
    }

    public static void arrayReversal(int[] list){

        /*
        数组翻转  通过for循环
        一个计数器正向索引
        一个计数器反向索引
         */
        for(int strat=0,end=list.length-1;strat<end;strat++,end--){
            // 交换赋值
            int temp = list[strat];
            list[strat]=list[end];
            list[end] = temp;
        }
        System.out.println(Arrays.toString(list));
    }

    // 私有方法
    private void privateMethod(){
        System.out.println(size);
        System.out.println(name);
        System.out.println(Arrays.toString(list));
    }
}

class Cat{
    String name;
    public Cat(){
        /*
        构造方法
        没有返回值类型
        方法名同类名一致
        创建对象时默认调用
        分为无参构造 有参构造
         特点:
         1.如果一个类没有构造方法,会默认生成无参构造方法
         2.如果手动给了任何构造方法 都不会生成.
         3. 构造方法可以重载
         */
        System.out.println("这是无参构造");
    }

    public Cat(String name){
        this.name = name;
        System.out.println("print instance variable: " + this.name);
    }
}