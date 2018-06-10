package pers.cabin.jichu.a5_designPattern.dm03_SingletonPattern;

/**
 * 懒汉式线程安全
 * Created by caiping on 2017/3/2.
 */
public class Singleton3 {

    private static Singleton3 instance;

    private Singleton3() {
    }

    public static Singleton3 getInstance() {
        synchronized (Singleton3.class) {
            if (instance == null) {
                instance = new Singleton3();
            }
        }
        return instance;
    }
}
