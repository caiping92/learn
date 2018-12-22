package pers.cabin.java.base.thread.myThread;

import pers.cabin.java.base.thread.resouces.Data;

/**
 * 对Data 数值进行减1 的 线程
 * <p>
 * Created by cc on 2016/11/3.
 */
public class Demo2NumberMinus implements Runnable {

    private Data data;

    public Demo2NumberMinus(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            data.minus();
        }
    }
}
