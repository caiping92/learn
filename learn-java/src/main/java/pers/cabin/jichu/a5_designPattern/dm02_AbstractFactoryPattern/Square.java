package pers.cabin.jichu.a5_designPattern.dm02_AbstractFactoryPattern;

/**
 * Created by caiping on 2017/3/2.
 */
public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}
