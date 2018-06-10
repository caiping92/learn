package pers.cabin.jichu.a5_designPattern.dm15_CommandPattern;

/**
 * Created by caiping on 2017/3/2.
 */
public class BuyStock implements Order {
    private Stock abcStock;

    public BuyStock(Stock abcStock) {
        this.abcStock = abcStock;
    }

    public void execute() {
        abcStock.buy();
    }
}
