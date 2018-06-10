package pers.cabin.spring.aop;

/**
 * 类文件中不是使用 class、interface、enum 在定义 Java 类
 * TxAspect 根本不是一个 Java 类，所以 aspect 也不是 Java 支持的关键字，它只是 AspectJ 才能识别的关键字。
 *
 * 指定当程序执行 Hello 对象的 sayHello() 方法时，
 * 系统将改为执行粗体字代码的花括号代码块，其中 proceed() 代表回调原来的 sayHello() 方法。
 *
 * ava 无法识别 TxAspect.java 文件的内容，所以我们要使用 ajc.exe 命令来编译上面的 Java 程序。
 * 为了能在命令行使用 ajc.exe 命令，需要把 AspectJ 安装目录下的 bin 路径（比如 E:\Java\AOP\aspectj1.6\bin 目录）添加到系统的 PATH 环境变量中。
 * 接下来执行如下命令进行编译：
 ajc -d . Hello.java TxAspect.java
 *
 * Created by caiping on 2017/9/23.
 */
public aspect TxAspect {

    // 指定执行 Hello.sayHello() 方法时执行下面代码块
    void around():call(void Hello.sayHello()){
        System.out.println("开始事务 ...");
        proceed();
        System.out.println("事务结束 ...");
    }
}
