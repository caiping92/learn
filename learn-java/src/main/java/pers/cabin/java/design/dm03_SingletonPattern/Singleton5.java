package pers.cabin.java.design.dm03_SingletonPattern;

/**
 * Created by caiping on 2017/3/2.
 */
public class Singleton5 {
    private Singleton5() {
    }

    private static class SingletonHolder {
        private static final Singleton5 INSTANCE = new Singleton5();
    }

    public static final Singleton5 getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
