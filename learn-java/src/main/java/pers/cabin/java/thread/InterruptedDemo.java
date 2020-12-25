package pers.cabin.java.thread;

import pers.cabin.java.StdOut;

import java.util.concurrent.locks.ReentrantLock;

public class InterruptedDemo {

    public static void main(String[] args) throws InterruptedException {

        int n = 2;
        Demo d = new Demo();
       /* Thread t1 = new Thread(d);
        Thread t2 = new Thread(d);*/

        Thread t1 = new Thread(d::run);
        Thread t2 = new Thread(d::run);

        t1.setName("t1");
        t2.setName("t2");

        t1.start();
        Thread.sleep(3000);

        t2.start();
        t2.interrupt();
        StdOut.println("t2 notify interrupted");

        t2.interrupt();
        StdOut.println(t2.getName() + "- " + t2.isInterrupted());

        t2.interrupt();
        StdOut.println(t2.getName() + "- " + t2.isInterrupted());

    }


    public static class Demo implements Runnable {

        private static ReentrantLock lock = new ReentrantLock();

        @Override
        public void run() {
            try {
                lock.lockInterruptibly();
                try {
                    //                lock.lock();
                    StdOut.println(Thread.currentThread().getName() + " running");
                    while (true) {
                        Thread.sleep(11111);
                    }
                } finally {
                    StdOut.println(Thread.currentThread().getName() + " run finished");
                    lock.unlock();
                }
            } catch (InterruptedException e) {
                StdOut.println(Thread.currentThread().getName() + " Interrupted");
            }
        }
    }
}
