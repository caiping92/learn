package pers.cabin.java.design.dm19_MementoPattern;

/**
 * Created by caiping on 2017/3/3.
 */
public class Memento {
    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
