package pers.cabin.jichu.a5_designPattern.dm05_PrototypePattern;

/**
 * Created by caiping on 2017/3/2.
 */
public class Rectangle extends Shape {
    public Rectangle() {
        type = "Rectangle";
    }

    @Override
    void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}
