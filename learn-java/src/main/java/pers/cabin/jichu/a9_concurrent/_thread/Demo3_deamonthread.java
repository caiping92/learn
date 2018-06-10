package pers.cabin.jichu.a9_concurrent._thread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * 守护线程
 * Created by caiping on 2017/9/26.
 */
public class Demo3_deamonthread {

    public static void main(String[] args) {

//    test1();

        test2();
//        test3();
    }

    private static void test4() {
        Thread t = new Thread(new Target2_task());
        t.setDaemon(true);
        t.setName("守护线程");
        t.start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    if (t.getState().equals(Thread.State.TERMINATED)) {
                        System.out.println(t.getName()+">>>结束<<<<<"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z").format(new Date(System.currentTimeMillis()))+">>"+new Random().nextFloat());
                        break;
                    }
                }
            }
        }).start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread[] init = ThreadPool.init(new Target2_task(), 5);
        for (int i = 0; i < init.length; i++) {
            Thread tmp = init[i];
            tmp.start();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        if (tmp.getState().equals(Thread.State.TERMINATED)) {
                            System.out.println(Thread.currentThread().getName()+">>>结束<<<<<"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z").format(new Date(System.currentTimeMillis()))+">>"+new Random().nextFloat());
                            break;
                        }
                    }
                }
            }).start();
        }
    }

    private static void test3() {
        Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
        Set<Thread> threads = allStackTraces.keySet();
        for (Thread t : threads) {
            System.out.println(t.getName());
        }
    }

    private static void test2() {
        Target target = new Target();
        Thread t = new Thread(target);
        t.setDaemon(true);
        t.setName("守护线程");
        t.start();
        System.out.println(t.getName() + ">>>开始<<<<<" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z").format(new Date(System.currentTimeMillis())) + ">>" + new Random().nextFloat());

       /* new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    if (t.getState().equals(Thread.State.TERMINATED)) {
                        System.out.println(t.getName() + ">>>结束<<<<<" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z").format(new Date(System.currentTimeMillis())) + ">>" + new Random().nextFloat());
                        break;
                    }
                }
            }
        }).start();*/


        Thread[] init = ThreadPool.init(new Target2_task(), 1);
        for (int i = 0; i < init.length; i++) {
            Thread tmp = init[i];
            tmp.start();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        if (tmp.getState().equals(Thread.State.TERMINATED)) {
                            System.out.println(Thread.currentThread().getName()+">>>结束<<<<<"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z").format(new Date(System.currentTimeMillis()))+">>"+new Random().nextFloat());
                            break;
                        }
                    }
                }
            }).start();
        }
    }

    private static void test1() {
        Thread t1 = new Thread(new Target2_task());

        System.out.println("t1.isDaemon():" + t1.isDaemon());

        Thread t2 = new Thread(new Target2_task());
        t1.setDaemon(true);

        t1.start();
        t2.start();

        System.out.println("t2.isDaemon():" + t1.isDaemon());
    }

}
