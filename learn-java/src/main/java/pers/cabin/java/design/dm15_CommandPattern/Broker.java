package pers.cabin.java.design.dm15_CommandPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by caiping on 2017/3/2.
 */
public class Broker {
    private List<Order> orderList = new ArrayList<Order>();

    public void takeOrder(Order order) {
        orderList.add(order);
    }

    public void placeOrders() {
        for (Order order : orderList) {
            order.execute();
        }
        orderList.clear();
    }
}
