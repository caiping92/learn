package pers.cabin.mybatis.proxy;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by caiping on 2017/3/16.
 */
public class HelloServiceJDKProxy implements InvocationHandler {
    /**
     * 真实服务对象
     */
    private Object target;

    /**
     * 绑定委托对象并返回一个代理类
     * @param target
     * @return
     */
    public Object bind(Object target) {
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    /**
     * 通过代理对象那个调用方法首先进入 这个方法
     * @param proxy 代理对象
     * @param method 被调用的方法
     * @param args 方法的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("JDK 动态代理开始...");

        Object result = null;
        result = method.invoke(target, args);
        System.out.println("JDK 动态代理调用结束 ...");

        return result;
    }


    @Test
    public void testJDKProxy() {
        HelloServiceJDKProxy helloServiceJDKProxy = new HelloServiceJDKProxy();
        HelloService helloService = (HelloService) helloServiceJDKProxy.bind(new HelloServiceImpl());

        helloService.sayHello("jdk 动态代理");

    }
}
