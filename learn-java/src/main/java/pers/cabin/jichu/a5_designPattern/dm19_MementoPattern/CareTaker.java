package pers.cabin.jichu.a5_designPattern.dm19_MementoPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by caiping on 2017/3/3.
 */
public class CareTaker {
    private List<Memento> mementoList = new ArrayList<Memento>();

    public void add(Memento state) {
        mementoList.add(state);
    }

    public Memento get(int index) {
        return mementoList.get(index);
    }
}
