package pers.cabin.java.juc;

import pers.cabin.java.StdOut;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {
    public static void main(String[] args) {


        Thread t1 = new Thread() {
            @Override
            public void run() {
                r();
            }
        };
        Thread t2 = new Thread() {
            @Override
            public void run() {
                r();
            }
        };


        t1.setName("t1");
        t2.setName("t2");

        t1.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t2.start();

        lock.lock();
        try {
            StdOut.println("start signal");
            cond.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }


    }


    private static final ReentrantLock lock = new ReentrantLock();
    private static final Condition cond = lock.newCondition();
    public static void r() {
        try {
            lock.lock();
            try {
                cond.await();
                StdOut.println(Thread.currentThread().getName() + " " + "run");
                Thread.sleep(1000);
                Thread.sleep(1000);
                cond.signal();
            } finally {
                lock.unlock();
                StdOut.println(Thread.currentThread().getName() + " run finished");
            }
          /*  lock.lock();
            try {
                cond.signal();
            } finally {
                lock.unlock();
            }*/
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
