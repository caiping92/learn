package pers.cabin.java.design.dm31_InterceptingFilterPattern;

/**
 * Created by caiping on 2017/3/3.
 */
public class AuthenticationFilter implements Filter {
    @Override
    public void execute(String request) {
        System.out.println("Authenticating request: " + request);
    }
}
