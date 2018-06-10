package pers.cabin.jichu.a5_designPattern.dm11_FacadePattern;

/**
 * Created by caiping on 2017/3/2.
 */
public class FacadePatternDemo {
    public static void main(String[] args) {
        ShapeMaker shapeMaker = new ShapeMaker();

        shapeMaker.drawCircle();
        shapeMaker.drawRectangle();
        shapeMaker.drawSquare();
    }
}
