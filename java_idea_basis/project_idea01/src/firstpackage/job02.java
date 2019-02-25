package firstpackage;
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
			但参数并没有声明的问题,如果调用方法而没有传入参数才会抛出异常
			声明的局部变量也是如此,如果调用时没有初始化才会抛出异常
			引用变量也可以用来比较他们的引用(字节)是否相同
			忽然想到:
			    除了对数据容量大小的优化外,避免无谓的引用变量与对象也是对内存的极大优化
			*/
    }
}


class Dog{
    // java封装
    // 私有的 只能通过方法获取
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
	传入实参时是传不进来的
	public void setName(String name){
		name = name;
	}
	*/

    public void setName(String na){
        name = na;
    }

    public int[] getList(){
        return list;
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
}