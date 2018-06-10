package pers.caiping.learn.java.thread.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

public class CountTaskDemo {

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        //1 加到100
        ForkJoinTask<Integer> countTaskFutrue = forkJoinPool.submit(new CountTask(1, 100));
        try {
            Integer res = countTaskFutrue.get();
            System.out.println(res);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
