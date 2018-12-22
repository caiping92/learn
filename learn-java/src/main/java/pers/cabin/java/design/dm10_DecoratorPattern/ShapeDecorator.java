package pers.cabin.java.design.dm10_DecoratorPattern;

/**
 * 创建实现了 Shape 接口的抽象装饰类。
 * Created by caiping on 2017/3/2.
 */
public abstract class ShapeDecorator implements Shape {

    protected Shape decoratedShape;

    public ShapeDecorator(Shape decoratedShape) {
        this.decoratedShape = decoratedShape;
    }

    public void draw() {
        decoratedShape.draw();
    }
}
