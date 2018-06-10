package pers.cabin.jichu.a5_designPattern.dm21_StatePattern;

/**
 * Created by caiping on 2017/3/3.
 */
public class StartState implements State {
    public void doAction(Context context) {
        System.out.println("Player is in start state");
        context.setState(this);
    }

    public String toString() {
        return "Start State";
    }
}
