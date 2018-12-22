package pers.cabin.java.design.visitor;

/**
 * 该类不会改变，直接修改visitor
 */
public class Dog extends Animal {
    @Override
    void eat(String s) {
        System.out.println("dog is eating " + s);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
