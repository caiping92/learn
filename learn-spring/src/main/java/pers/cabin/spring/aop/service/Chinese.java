package pers.cabin.spring.aop.service;

import org.springframework.stereotype.Component;

/**
 * Created by caiping on 2017/9/23.
 */
@Component
public class Chinese {

    // 实现 Person 接口的 sayHello() 方法
    public String sayHello(String name)
    {
        System.out.println("-- 正在执行 sayHello 方法 --");
// 返回简单的字符串
        return name + " Hello , Spring AOP";
    }
    // 定义一个 eat() 方法
    public void eat(String food)
    {
        System.out.println("我正在吃 :"+ food);
    }
}
