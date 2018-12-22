package pers.cabin.java.design.dm13_DynamicProxyPattern;

/**
 * Created by caiping on 2017/3/2.
 */
public class RealSubject implements Subject {
    @Override
    public void doSomething() {
        System.out.println("call doSomething()");
    }

    @Override
    public void doAnything() {
        System.out.print("\r\n call doAnything");
    }

}
