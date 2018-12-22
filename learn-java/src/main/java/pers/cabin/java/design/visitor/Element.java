package pers.cabin.java.design.visitor;

public interface Element {
    void accept(Visitor visitor);
}
