package pers.cabin.jichu.a5_designPattern.dm07_BridgePattern;

/**
 * Created by caiping on 2017/3/2.
 */
public class GreenCircle implements DrawAPI {
    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Drawing Circle[ color: green, radius: "
                + radius + ", x: " + x + ", " + y + "]");
    }
}
