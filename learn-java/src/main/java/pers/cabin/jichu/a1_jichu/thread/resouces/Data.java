package pers.cabin.jichu.a1_jichu.thread.resouces;

/**
 * 封装成一个 数对象，这个数 有增加，有减少方法
 * <p>
 * 线程资源共享方法：
 * 1. 一个线程内，资源共享；->成员变量，成员
 * 2. 多个线程之间，资源共享  ->成员对象
 * <p>
 * 如果有2个以上的线程调用这个方法，若有wait()，那么就用 notifyAll()唤醒，不然会出现死锁
 * <p>
 * Created by cc on 2016/11/3.
 */
public class Data {
    private int num;

    public Data(int num) {
        this.num = num;
    }

    /**
     * 对本数值 进行减1
     */
    public synchronized void minus() {
        System.out.println(--this.num);
    }

    /**
     * 对本数值进行+1
     */
    public synchronized void add() {
        System.out.println(++this.num);
    }

}
