package pers.cabin.jichu.a5_designPattern.dm13_ProxyPattern;

/**
 * Created by caiping on 2017/3/2.
 */
public class ProxyPatternDemo {
    public static void main(String[] args) {
        Image image = new ProxyImage("test_10mb.jpg");

        //图像将从磁盘加载
        image.display();
        System.out.println("");
        //图像将无法从磁盘加载
        image.display();
    }
}
