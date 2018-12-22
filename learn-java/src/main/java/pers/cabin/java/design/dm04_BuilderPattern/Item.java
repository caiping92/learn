package pers.cabin.java.design.dm04_BuilderPattern;

/**
 * Created by caiping on 2017/3/2.
 */
public interface Item {
    public String name();

    public Packing packing();

    public float price();
}
