package pers.cabin.spring.aop;

import org.springframework.context.ApplicationContext;
import pers.cabin.spring.aop.service.Chinese;
import pers.cabin.spring.aop.service.Student;
import pers.cabin.spring.utils.SpringUtils;

/**
 *Spring AOP 无需使用任何特殊命令对 Java 源代码进行编译，它采用运行时动态地、在内存中临时生成“代理类”的方式来生成 AOP 代理。
 *
 * Spring 允许使用 AspectJ Annotation 用于定义方面（Aspect）、切入点（Pointcut）和增强处理（Advice），Spring框架则可识别并根据这些 Annotation 来生成 AOP 代理。
 *
 * Spring 只是使用了和 AspectJ 5 一样的注解，但并没有使用 AspectJ 的编译器或者织入器（Weaver），底层依然使用的是 Spring AOP，依然是在运行时动态生成 AOP 代理，并不依赖于 AspectJ 的编译器或者织入器。
 *
 * Spring 依然采用运行时生成动态代理的方式来增强目标对象
 *
 * Created by caiping on 2017/9/23.
 */
public class Demo2 {

    private  static ApplicationContext applicationContext = SpringUtils.getApplicationContext();

    public static void main(String[] args){
        System.out.println("----------------------------------------------------------------");

        Chinese chinese = (Chinese) applicationContext.getBean("chinese");
        chinese.sayHello("ccc");
        System.out.println("----------------------------------------------------------------");

        Student student = (Student) applicationContext.getBean("student");
        student.getName();
        student.getAge();
        student.printThrowException();
        System.out.println("----------------------------------------------------------------");
    }
}
