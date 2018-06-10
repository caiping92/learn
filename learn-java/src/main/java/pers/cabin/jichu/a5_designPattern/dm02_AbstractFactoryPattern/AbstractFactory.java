package pers.cabin.jichu.a5_designPattern.dm02_AbstractFactoryPattern;

/**
 * Created by caiping on 2017/3/2.
 */
public abstract class AbstractFactory {
    abstract Color getColor(String color);

    abstract Shape getShape(String shape);
}
