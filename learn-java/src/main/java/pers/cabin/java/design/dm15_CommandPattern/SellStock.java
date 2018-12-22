package pers.cabin.java.design.dm15_CommandPattern;

/**
 * Created by caiping on 2017/3/2.
 */
public class SellStock implements Order {
    private Stock abcStock;

    public SellStock(Stock abcStock) {
        this.abcStock = abcStock;
    }

    public void execute() {
        abcStock.sell();
    }
}
