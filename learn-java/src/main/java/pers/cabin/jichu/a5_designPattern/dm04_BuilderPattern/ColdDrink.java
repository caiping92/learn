package pers.cabin.jichu.a5_designPattern.dm04_BuilderPattern;

/**
 * Created by caiping on 2017/3/2.
 */
public abstract class ColdDrink implements Item {
    @Override
    public Packing packing() {
        return new Bottle();
    }

    @Override
    public abstract float price();
}
