package pers.cabin.java.design.dm01_FactoryPattern;

/**
 * Created by caiping on 2017/3/2.
 */
public class TestFactory {
    public static void main(String[] args) {
        ShapeFactory factory = new ShapeFactory();
        Shape square = factory.getShape("square");
        square.draw();
    }

}
