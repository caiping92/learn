package pers.cabin.jichu.a5_designPattern.dm21_StatePattern;

/**
 * Created by caiping on 2017/3/3.
 */
public class Context {
    private State state;

    public Context() {
        state = null;
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }
}
