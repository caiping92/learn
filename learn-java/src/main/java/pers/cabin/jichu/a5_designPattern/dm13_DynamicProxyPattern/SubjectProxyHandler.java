package pers.cabin.jichu.a5_designPattern.dm13_DynamicProxyPattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by caiping on 2017/3/2.
 */
public class SubjectProxyHandler implements InvocationHandler {
    private Object proxied;

    public SubjectProxyHandler(Object proxied) {
        this.proxied = proxied;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//        在跳转目标对象之前，执行的操作
        if (method.getName().equals("doSomething")) {
            System.out.println("调用doSomthing 方法，已经记录在案");
        }
//        .........

//        转掉目标对象方法
        return method.invoke(proxied, args);
    }
}
