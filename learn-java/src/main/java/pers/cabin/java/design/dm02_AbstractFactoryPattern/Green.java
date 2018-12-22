package pers.cabin.java.design.dm02_AbstractFactoryPattern;

/**
 * Created by caiping on 2017/3/2.
 */
public class Green implements Color {
    @Override
    public void fill() {
        System.out.println("Inside Green::fill() method.");
    }
}
