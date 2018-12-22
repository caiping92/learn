package pers.cabin.java.design.dm14_ChainofResponsibilityPattern;

/**
 * Created by caiping on 2017/3/2.
 */
public class ErrorLogger extends AbstractLogger {
    public ErrorLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Error Console::Logger: " + message);
    }
}
