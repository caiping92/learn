package pers.cabin.jichu.a5_designPattern.dm25_VisitoPattern;

/**
 * Created by caiping on 2017/3/3.
 */
public class Mouse implements ComputerPart {
    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }
}
