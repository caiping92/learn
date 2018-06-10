package pers.cabin.jichu.a5_designPattern.dm05_PrototypePattern;

/**
 * Created by caiping on 2017/3/2.
 */
public class Square extends Shape {
    public Square() {
        type = "Square";
    }

    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}
