package pers.cabin.java.design.dm07_BridgePattern;

/**
 * Created by caiping on 2017/3/2.
 */
public class RedCircle implements DrawAPI {
    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Drawing Circle[ color: red, radius: "
                + radius + ", x: " + x + ", " + y + "]");
    }
}
