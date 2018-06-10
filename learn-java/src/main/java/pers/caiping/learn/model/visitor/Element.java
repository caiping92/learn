package pers.caiping.learn.model.visitor;

public interface Element {
    void accept(Visitor visitor);
}
