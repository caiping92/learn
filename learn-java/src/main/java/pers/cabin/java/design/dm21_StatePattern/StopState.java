package pers.cabin.java.design.dm21_StatePattern;

/**
 * Created by caiping on 2017/3/3.
 */
public class StopState implements State {
    public void doAction(Context context) {
        System.out.println("Player is in stop state");
        context.setState(this);
    }

    public String toString() {
        return "Stop State";
    }
}
