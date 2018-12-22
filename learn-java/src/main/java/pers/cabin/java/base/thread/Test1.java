package pers.cabin.java.base.thread;

import pers.cabin.java.base.thread.myThread.Demo1;

/**
 * Created by cc on 2016/11/3.
 */
public class Test1 {

    public static void main(String[] args) {
        Demo1 d1 = new Demo1("小m");
        Demo1 d2 = new Demo1("大N");
        d1.start();
        d2.start();
    }

}
