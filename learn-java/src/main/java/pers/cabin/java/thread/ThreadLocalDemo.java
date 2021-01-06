package pers.cabin.java.thread;

import pers.cabin.java.StdOut;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

public class ThreadLocalDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        int n = 3;

        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(n, n, Integer.MAX_VALUE, TimeUnit.DAYS, new SynchronousQueue<>(), Executors.defaultThreadFactory());
        List<Future<Void>> tmp = new ArrayList<>();
        CalcTask calcTask = new CalcTask();
        for (int i = 0; i < n; i++) {
            Future<Void> submit = poolExecutor.submit(calcTask);
            tmp.add(submit);
        }
        for (Future f : tmp) {
            f.get();
        }
        poolExecutor.shutdown();
        StdOut.println("All finished");
    }


    public static class CalcTask implements Callable<Void> {

        private ThreadLocal<Map<String, String>> localSpace = new ThreadLocal<>();

        @Override
        public Void call() throws Exception {
            Map<String, String> map = localSpace.get();
            if (map == null) {
                synchronized (this) {
                    map = localSpace.get();
                    if (map == null) {
                        StdOut.println("init local space");
                        map = new ConcurrentHashMap<>();
                    }
                }
            }
            map.put(Thread.currentThread().getName(), "0");
            try {
                Thread.sleep(2000);
                StdOut.println("localSpace size: "+map.size());
                map.forEach((k, v) -> StdOut.println(localSpace.hashCode() +": "+k + "->" + v));
                showAndClear();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        public void showAndClear() {
            Map<String, String> map = localSpace.get();
            if (map != null) {
                map.forEach((k, v) -> StdOut.println(k + "->" + v));
            }else {
                StdOut.println("localSpace is null when call showAndClear");
            }
            localSpace.remove();
        }
    }

}
