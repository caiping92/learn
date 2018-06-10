package pers.cabin.jichu.a5_designPattern.dm04_BuilderPattern;

/**
 * Created by caiping on 2017/3/2.
 */
public class Pepsi extends ColdDrink {
    @Override
    public String name() {
        return "Pepsi";
    }

    @Override
    public float price() {
        return 35.0f;
    }
}
