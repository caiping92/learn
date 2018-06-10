package pers.cabin.jichu.a1_jichu.thread;

/**
 * Created by cc on 2016/11/3.
 */
public class Test3 {

    public static void main(String[] args) {
        Add add = new Add();
        Thread add1 = new Thread(add);
        Thread add2 = new Thread(add);

        add1.start();
        add2.start();

    }

}

class Add implements Runnable {
    private int num = 10;

    @Override
    public void run() {
        while (true) {
            System.out.println(++num);
        }
    }
}

class Minus implements Runnable {
    private int num = 10;

    @Override
    public void run() {
        while (true) {
            System.out.println(--num);
        }
    }
}
