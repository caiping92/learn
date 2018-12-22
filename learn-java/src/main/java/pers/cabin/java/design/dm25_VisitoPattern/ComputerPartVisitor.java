package pers.cabin.java.design.dm25_VisitoPattern;

/**
 * Created by caiping on 2017/3/3.
 */
public interface ComputerPartVisitor {
    public void visit(Computer computer);

    public void visit(Mouse mouse);

    public void visit(Keyboard keyboard);

    public void visit(Monitor monitor);
}
