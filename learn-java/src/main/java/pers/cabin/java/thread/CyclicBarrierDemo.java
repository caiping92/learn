package pers.cabin.java.thread;

import pers.cabin.java.StdOut;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class CyclicBarrierDemo {


    public static void main(String[] args) throws InterruptedException {

        int n = 3;

        AtomicInteger atomicInteger = new AtomicInteger();

        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(
                n,
                n,
                Integer.MAX_VALUE,
                TimeUnit.MILLISECONDS,
                new SynchronousQueue<>(),
                Executors.defaultThreadFactory())
                ;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(1, () -> {
            StdOut.println("CyclicBarrier Action "+ atomicInteger.addAndGet(1));
        });
        for (int i = 0; i < n; i++) {
            poolExecutor.execute(new BarrTask(cyclicBarrier));
        }

        Thread.sleep(10000000);

    }


    private static class BarrTask implements Runnable {

        private final CyclicBarrier barrier;

        public BarrTask(CyclicBarrier barrier) {
            this.barrier = barrier;
        }

        @Override
        public void run() {
            try {
                StdOut.println(Thread.currentThread() + " run start ");
                Thread.sleep(1000);
                barrier.await();
                StdOut.println(Thread.currentThread() + " run finished");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}

