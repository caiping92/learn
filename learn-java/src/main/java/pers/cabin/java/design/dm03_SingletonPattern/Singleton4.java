package pers.cabin.java.design.dm03_SingletonPattern;

/**
 * Created by caiping on 2017/3/2.
 */
public class Singleton4 {
    private static Singleton4 instance;

    private Singleton4() {
    }

    public synchronized static Singleton4 getInstance() {
        if (instance == null) {
            instance = new Singleton4();
        }
        return instance;
    }
}
