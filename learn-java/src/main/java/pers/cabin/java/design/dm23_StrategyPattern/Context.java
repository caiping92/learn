package pers.cabin.java.design.dm23_StrategyPattern;

/**
 * Created by caiping on 2017/3/3.
 */
public class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public int executeStrategy(int num1, int num2) {
        return strategy.doOperation(num1, num2);
    }
}
