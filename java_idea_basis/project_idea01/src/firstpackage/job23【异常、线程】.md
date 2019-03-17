# day05 【异常、线程】

## 一. 异常

### 1. 错误和异常

**程序中的错误和异常**

- Error 错误, 遇到了问题, 不能自己解决.
- Exception 异常, 遇到了问题, 可以自己解决.

### 2. 异常的分类

* Throwable 所有异常的超类
* ​ Exception (可以被继承即自定义异常):
  * RuntimeException 运行时异常
  * IOException  编译时异常

### 3. 产生原因

```java
public static void main(String[] args) {

    String s = null;

    Objects.requireNonNull(s);

}

// =============================================================

public static <T> T requireNonNull(T obj) {
    // 对参数和null做了判断
    if (obj == null) {
        // 如果是null, 就执行下面的代码
        // 抛出了一个异常对象
        throw new NullPointerException();
    }
    return obj;
}
```

**虚拟机是如何处理异常**

- 虚拟机将异常的类名, 异常的信息以及异常出现的位置打印到控制台, 并且程序终止运行

### 4. 处理异常的两种方式

- 运行时异常: 虽然也可以处理, 但是不处理, 需要修改代码.
- 编译时异常: 必须处理



#### (1) throws抛出异常

- 抛出之后的作用

  编译时异常不会报错, 最终抛给虚拟机.



- 编译时异常(未雨绸缪)
  - 需要我们决定, 如果出现了异常, 我们应该怎么办
    1. 通过throws抛出, 抛给虚拟机, 让虚拟机去处理.
    2. 通过try-catch处理

#### (2) try-catch处理异常

- 处理的方式: 按alt + enter > 下箭头 > 回车  ,   使用try-catch语句体将异常包尾

- 处理了之后的作用

  编译时异常不会报错, 异常信息hi打印出来, 下面的代码可以继续执行



**try-catch语句体**

- try: 用来检测异常
  - try中如果有多行代码, 而上面的代码有异常被检测到并catch捕捉了起来, 下面的代码就不会执行
- catch: 用来捕捉异常
  - catch后面的异常声明, 就是用来接收try中检测到的异常对象, `Exception e`
  - `e.printStackTrace();` : 用来打印异常类名, 信息, 位置, 但是**不会终止程序**.

**finally**

- finally是try-catch语句体中的一部分,  他的作用是, 在finally里面的代码, 一定会执行(除了遇到System.exit()).
- finally一般会存放释放资源的代码



**三种格式**

- try - catch
- try - finally : 只需要让一段代码一定执行的时候
- try - catch - finally



## 二. 自定义异常

**模拟用户注册**

**自定义异常**

1. 创建一个类, 继承异常类(Exception, RuntimeException)
2. 根据父类生成可以指定异常信息的构造方法
3. 在其他位置抛出(throw)异常对象

| 关键字 | 位置         | 跟着的内容     | 后面内容的个数     |
| ------ | ------------ | -------------- | ------------------ |
| throw  | 方法中       | 跟的是异常对象 | 只能跟一个异常对象 |
| throws | 方法声明后面 | 跟             | 可以跟多个异常类名 |

```java
public class RegisterException extends Exception{

    public RegisterException() {
    }

    public RegisterException(String message) {
        super(message);
    }
}
```



## 三. 线程

**线程和进程**

- 进程: 运行的程序
- 线程: 进程是有多条线程组成的 

**多线程的并发和并行**

- 并行: 同一个时间点上, 多个线程同时执行, 需要多核CPU
- 并发: 同一个时间段上, 多个线程同时请求执行, CPU只有1个, cpu在不断的切换执行权

