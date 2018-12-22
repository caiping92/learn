package pers.cabin.java.thread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created by caiping on 2017/9/26.
 */
public class Target2_task implements Runnable {

    private volatile long count = 0;

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ">>>count:" + (++count) + "<<<<<" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z").format(new Date(System.currentTimeMillis())) + ">>" + new Random().nextFloat());
    }


}
