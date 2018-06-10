package pers.cabin.jichu.a5_designPattern.dm23_StrategyPattern;

/**
 * Created by caiping on 2017/3/3.
 */
public class OperationMultiply implements Strategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 * num2;
    }
}
