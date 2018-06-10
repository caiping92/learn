package pers.cabin.jichu.a5_designPattern.dm18_MediatorPattern;

/**
 * Created by caiping on 2017/3/3.
 */
public class MediatorPatternDemo {
    public static void main(String[] args) {
        User robert = new User("Robert");
        User john = new User("John");

        robert.sendMessage("Hi! John!");
        john.sendMessage("Hello! Robert!");
    }
}
