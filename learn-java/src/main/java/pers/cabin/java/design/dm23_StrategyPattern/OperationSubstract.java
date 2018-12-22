package pers.cabin.java.design.dm23_StrategyPattern;

/**
 * Created by caiping on 2017/3/3.
 */
public class OperationSubstract implements Strategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 - num2;
    }
}
