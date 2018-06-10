package pers.cabin.jichu.a1_jichu.thread;

import pers.cabin.jichu.a1_jichu.thread.myThread.Demo1;

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
