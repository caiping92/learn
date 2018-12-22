package pers.cabin.java.base.thread.resouces;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用synchronized 同步线程，那么 一个对象 对应着一个监视器（一个对象自带监视器）
 * 如果使用 锁 则 可以创建多个监视器（JDK1.5解决方案），然后使用监视器来监视多线程状态
 * lock(); 获取锁
 * unlock; 释放锁，通常再finally中使用
 * <p>
 * Condition接口，出现代替Object中的wait  notify notifyAll
 * 将这些监视器进行了封装，编程COndition监视器对象
 * await  singal   signalAll
 * <p>
 * Created by cc on 2016/11/4.
 */
public class Test {

    public void test1() {
//    TODO  创建一个所对象
        Lock lock = new ReentrantLock();
//    TODO  通过已有的锁获取锁上的对象
        Condition con = lock.newCondition();

    }

    public void test2() {
//        TODO  通过已有的锁获取两组锁，一组监视生产者，一组监视消费者
        Lock lock = new ReentrantLock();
//        TODO  生产者监视器
        Condition con_produce = lock.newCondition();
//        TODO  消费者监视器
        Condition con_consumer = lock.newCondition();

//        TODO  使用相应监视器唤醒
        try {
            con_consumer.await();
            con_consumer.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

//

}
