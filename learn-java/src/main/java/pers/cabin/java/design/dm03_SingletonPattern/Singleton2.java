package pers.cabin.java.design.dm03_SingletonPattern;

/**
 * 懒汉式
 * 线程不安全
 * Created by caiping on 2017/3/2.
 */
public class Singleton2 {
    private static Singleton2 instance;

    private Singleton2() {
    }

    public static Singleton2 getInstance() {
        if (instance == null) {
            instance = new Singleton2();
        }
        return instance;
    }
}
