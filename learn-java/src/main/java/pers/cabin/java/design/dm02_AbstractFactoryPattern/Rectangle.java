package pers.cabin.java.design.dm02_AbstractFactoryPattern;

/**
 * Created by caiping on 2017/3/2.
 */
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}
