package pers.cabin.jichu.a5_designPattern.dm04_BuilderPattern;

/**
 * Created by caiping on 2017/3/2.
 */
public class ChickenBurger extends Burger {
    @Override
    public String name() {
        return "Chicken Burger";
    }

    @Override
    public float price() {
        return 50.5f;
    }
}
