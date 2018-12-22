package pers.cabin.java.design.dm25_VisitoPattern;

/**
 * Created by caiping on 2017/3/3.
 */
public class Keyboard implements ComputerPart {
    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }
}
