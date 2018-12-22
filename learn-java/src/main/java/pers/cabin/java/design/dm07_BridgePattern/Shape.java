package pers.cabin.java.design.dm07_BridgePattern;

/**
 * Created by caiping on 2017/3/2.
 */
public abstract class Shape {
    protected DrawAPI drawAPI;

    protected Shape(DrawAPI drawAPI) {
        this.drawAPI = drawAPI;
    }

    public abstract void draw();
}
