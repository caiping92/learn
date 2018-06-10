package pers.cabin.jichu.a5_designPattern.dm20_ObserverPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by caiping on 2017/3/3.
 */
public class Subject {
    private List<Observer> observers
            = new ArrayList<Observer>();
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void notifyAllObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
