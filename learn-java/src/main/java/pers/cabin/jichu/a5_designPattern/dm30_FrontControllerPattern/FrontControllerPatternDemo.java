package pers.cabin.jichu.a5_designPattern.dm30_FrontControllerPattern;

/**
 * Created by caiping on 2017/3/3.
 */
public class FrontControllerPatternDemo {
    public static void main(String[] args) {
        FrontController frontController = new FrontController();
        frontController.dispatchRequest("HOME");
        frontController.dispatchRequest("STUDENT");
    }
}
