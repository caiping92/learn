package pers.cabin.java.design.dm14_ChainofResponsibilityPattern;

/**
 * Created by caiping on 2017/3/2.
 */
public class FileLogger extends AbstractLogger {
    public FileLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("File::Logger: " + message);
    }
}
