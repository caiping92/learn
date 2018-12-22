package pers.cabin.java.design.dm02_AbstractFactoryPattern;

/**
 * Created by caiping on 2017/3/2.
 */
public abstract class AbstractFactory {
    abstract Color getColor(String color);

    abstract Shape getShape(String shape);
}
