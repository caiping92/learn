package pers.cabin.java.design.dm20_ObserverPattern;

/**
 * Created by caiping on 2017/3/3.
 */
public abstract class Observer {
    protected Subject subject;

    public abstract void update();

}
