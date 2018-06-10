package pers.cabin.imageprocess;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Hello world!
 *
 */
public class Demo1 {

    /**
     *
     * 通过BufferedImage获取Graphics
     */
    public Graphics getGraphicsByImageBuff() {

        return new BufferedImage(400,300,BufferedImage.TYPE_3BYTE_BGR).getGraphics();
    }

    /**
     * 通过Swing组件获取Graphics
     * @return
     */
    public Graphics getGraphicsByButton() {
        return new JButton().getGraphics();
    }

}
