package pers.cabin.java.design.dm02_AbstractFactoryPattern;

/**
 * Created by caiping on 2017/3/2.
 */
public class Red implements Color {
    @Override
    public void fill() {
        System.out.println("Inside Red::fill() method.");
    }
}
