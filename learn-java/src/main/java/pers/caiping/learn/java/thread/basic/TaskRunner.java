package pers.caiping.learn.java.thread.basic;

public class TaskRunner implements Runnable {
    @Override
    public void run() {
        System.out.println("hello");
    }
}
