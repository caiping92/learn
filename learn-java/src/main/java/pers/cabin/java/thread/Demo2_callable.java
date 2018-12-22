package pers.cabin.java.thread;

import java.util.Random;
import java.util.concurrent.*;

/**
 * http://blog.csdn.net/ghsau/article/details/7451464
 * <p>
 * 线程有无返回结果
 * 无返回结果，直接 new Thread 或者 实现Runable接口，在用Thread调用，
 * 有返回结果，使用Callable 封装业务，复写Call 方法，使用callable 实例化TaskFuture，并使用Thread 调用结果
 * <p>
 * Callbale RunableFuture
 * Created by caiping on 2017/9/26.
 */
public class Demo2_callable {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return new Random().nextInt(100);
            }
        };

        RunnableFuture<Integer> future = new FutureTask<Integer>(callable);
        new Thread(future).start();
        Thread.sleep(5000);// 可能做一些事情
        Integer res = future.get();
        System.out.println(res);

    }
}
