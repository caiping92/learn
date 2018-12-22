package pers.cabin.java.design.dm13_DynamicProxyPattern;

import java.lang.reflect.Proxy;

/**
 * Created by caiping on 2017/3/2.
 */
public class DynamicProxy {

    public static void main(String args[]) {
        Subject realSubject = new RealSubject();
        Subject subject = (Subject) Proxy.newProxyInstance(Subject.class.getClassLoader(),
                new Class[]{Subject.class},
                new SubjectProxyHandler(realSubject));
        subject.doSomething();
        System.out.println();
        subject.doAnything();
    }
}
