package pers.cabin.imageprocess;

import org.junit.Before;
import org.junit.Test;

import java.awt.*;

/**
 * Demo1 Graphics图形设备的获取和使用
 * Created by caiping on 2017/3/13.
 */
public class Demo1Test {

    Demo1 demo1 = null;
    @Before
    public void setUp() {
        demo1 = new Demo1();
    }

    @Test
    public void testGetGraphics() {
        Graphics graphics = demo1.getGraphicsByImageBuff();

        graphics.setColor(Color.blue);
        graphics.drawRect(10,10,50,10);

        graphics.dispose();
    }
}
