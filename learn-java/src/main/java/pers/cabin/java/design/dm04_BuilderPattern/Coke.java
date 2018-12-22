package pers.cabin.java.design.dm04_BuilderPattern;

/**
 * Created by caiping on 2017/3/2.
 */
public class Coke extends ColdDrink {
    @Override
    public String name() {
        return "Coke";
    }

    @Override
    public float price() {
        return 30.0f;
    }
}
