package pers.cabin.jichu.a5_designPattern.dm31_InterceptingFilterPattern;

/**
 * Created by caiping on 2017/3/3.
 */
public class DebugFilter implements Filter {
    @Override
    public void execute(String request) {
        System.out.println("request log: " + request);
    }
}
