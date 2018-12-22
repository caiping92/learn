package pers.cabin.java.base.thread.myThread;

/**
 * Created by cc on 2016/11/3.
 */
public class Demo1 extends Thread {

    private String name;
    /**
     * 执行次数
     */
    private int num = 10;

    public Demo1(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < this.num; i++) {
            System.out.println(i + "->" + this.name);
        }
    }
}
