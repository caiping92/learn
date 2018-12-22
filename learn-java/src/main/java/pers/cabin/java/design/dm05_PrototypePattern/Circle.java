package pers.cabin.java.design.dm05_PrototypePattern;

/**
 * Created by caiping on 2017/3/2.
 */
public class Circle extends Shape {
    public Circle() {
        type = "Circle";
    }

    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}
