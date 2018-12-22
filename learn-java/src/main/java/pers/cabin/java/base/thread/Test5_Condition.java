package pers.cabin.java.base.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * wait 和 sleep 区别
 * 1.waite 可以指定时间，也可以不指定
 * sleep必须指定时间
 * 2.在同步时，wait释放执行权，释放锁；而sleep释放执行权，不释放锁
 * <p>
 * 注意：谁拿锁，谁执行；（同步代码块中，不一定只有一个线程，也可以有多个线程）
 * <p>
 * class Demo{
 * void m1(){
 * synchronized(this){
 * wait();  //TODO  进入的线程都在这里进入等待，释放执行权。t1    t2  t3  ....
 * }
 * }
 * <p>
 * void m2(){
 * synchronized (this){
 * notifyAll(); //TODO  唤醒该监视器的所有线程，即 t1 t2 等线程唤醒
 * }//  TODO    释放锁
 * }
 * }
 * <p>
 * 控制线程结束，通常用标记来完成，run方法结束，线程结束。对外提供一个可以改变 flag标记的方法    ->run方法内没有 wait方法
 * 可以使用 interrupt()方法，将线程从冻结状态强制恢复到运行中来，让线程具备 cpu的执行资格，但是强制动作会发生中断异常
 * <p>
 * 则对线程进行操作需要：
 * ------------------------------
 * interrupt();
 * stopTarget()；
 * ---------------------------------
 * t1.join();      //t1 线程加入进来，临时加入一个线程，运算时，可以使用join()方法
 * <p>
 * <p>
 * Created by cc on 2016/11/4.
 */
public class Test5_Condition {
    final Lock lock = new ReentrantLock();
    final Condition notFull = lock.newCondition();
    final Condition notEmpty = lock.newCondition();

    final Object[] items = new Object[100];
    int putptr, takeptr, count;

    public void put(Object x) throws InterruptedException {
        lock.lock();
        try {
            while (count == items.length)
                notFull.await();
            items[putptr] = x;
            if (++putptr == items.length) putptr = 0;
            ++count;
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    public Object take() throws InterruptedException {
        lock.lock();
        try {
            while (count == 0)
                notEmpty.await();
            Object x = items[takeptr];
            if (++takeptr == items.length) takeptr = 0;
            --count;
            notFull.signal();
            return x;
        } finally {
            lock.unlock();
        }
    }

}

/**
 * 定义标记来结束线程
 */
class Target implements Runnable {

    //  TODO  线程结束标记. 默认不结束
    private boolean flag = false;

    public void stopTarget() {
        flag = true;
    }

    //    资源
    private Object obj;

    public Target(Object obj) {
        this.obj = obj;
    }

    @Override
    public void run() {
        //TODO 不结束线程时，执行...
        while (!flag) {
        }

//        TODO  调用资源的方法，进行相应的操作
    }
}

