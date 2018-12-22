package pers.cabin.java.thread;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by caiping on 2018/1/22.
 */
public class ScheduThreadPoolDemo {

    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
//        scheduledExecutorService.scheduleAtFixedRate(new Task_Test1(), 0,1, TimeUnit.SECONDS);
        scheduledExecutorService.scheduleWithFixedDelay(new Task_Test1(), 0, 1, TimeUnit.SECONDS);
    }
}
