package pers.cabin.jichu.a5_designPattern.dm16_InterpreterPattern;

/**
 * Created by caiping on 2017/3/3.
 */
public class TerminalExpression implements Expression {
    private String data;

    public TerminalExpression(String data) {
        this.data = data;
    }

    @Override
    public boolean interpret(String context) {
        if (context.contains(data)) {
            return true;
        }
        return false;
    }
}
