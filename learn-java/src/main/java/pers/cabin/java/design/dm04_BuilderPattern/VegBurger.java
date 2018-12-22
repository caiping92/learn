package pers.cabin.java.design.dm04_BuilderPattern;

/**
 * Created by caiping on 2017/3/2.
 */
public class VegBurger extends Burger {
    @Override
    public String name() {
        return "Veg Burger";
    }

    @Override
    public float price() {
        return 25.0f;
    }
}
