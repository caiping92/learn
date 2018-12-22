package pers.cabin.java.design.dm25_VisitoPattern;

/**
 * Created by caiping on 2017/3/3.
 */
public interface ComputerPart {
    public void accept(ComputerPartVisitor computerPartVisitor);
}
