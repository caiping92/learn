package pers.cabin.java.io.other;

import java.util.Date;

/**
 * getClass 返回得是 当前运行时类
 * Created by cc on 2016/11/14.
 */
public class Test5 extends Date {

    public static void main(String[] args) {
        new Test5().get();
    }

    public void get() {
        System.out.println("super.getClass  " + super.getClass().getName());
        System.out.println("this.getClass  " + this.getClass().getName());
    }
}
