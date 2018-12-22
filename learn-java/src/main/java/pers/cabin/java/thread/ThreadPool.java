package pers.cabin.java.thread;

/**
 * Created by caiping on 2017/9/26.
 */
public class ThreadPool {

    public static Thread[] init(Runnable target, int size) {

        if (size >= 0) {
            Thread[] threads = new Thread[size];
            for (int i = 0; i < size; i++) {
                threads[i] = new Thread(target);
            }
            return threads;
        }
        return new Thread[0];
    }
}
