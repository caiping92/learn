package pers.cabin.jichu.a9_concurrent._thread;

/**
 * Created by caiping on 2017/9/26.
 */
public class Target implements Runnable{

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
