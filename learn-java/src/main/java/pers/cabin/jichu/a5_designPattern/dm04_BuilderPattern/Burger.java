package pers.cabin.jichu.a5_designPattern.dm04_BuilderPattern;

/**
 * Created by caiping on 2017/3/2.
 */
public abstract class Burger implements Item {

    @Override
    public Packing packing() {
        return new Wrapper();
    }

    @Override
    public abstract float price();
}
