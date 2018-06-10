package pers.cabin.jichu.a9_concurrent._thread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created by caiping on 2017/9/26.
 */
public class Task_Test1 implements Runnable{

    private volatile long count = 0;

    @Override
    public void run() {

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName()+">>>count:"+(++count)+"<<<<<"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z").format(new Date(System.currentTimeMillis()))+">>"+new Random().nextFloat());
    }


}
