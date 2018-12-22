package pers.cabin.java.thread;

/**
 * 线程同步
 * http://geek.csdn.net/news/detail/237584
 * <p>
 * 1. synchronized 同步方法
 * 2. synchronized 同步代码块
 * 3. 使用lock
 * 4. 用 volatile 实现线程同步
 * a.volatile关键字为域变量的访问提供了一种免锁机制
 * b.使用volatile修饰域相当于告诉虚拟机该域可能会被其他线程更新
 * c.因此每次使用该域就要重新计算，而不是使用寄存器中的值
 * d.volatile不会提供任何原子操作，它也不能用来修饰final类型的变量
 * 5. 使用局部变量实现线程同步
 * ThreadLocal
 * <p>
 * <p>
 * Created by caiping on 2017/9/21.
 */
public class Demo1_synchronized {

    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        final Bank bank = new Bank();

        Thread tadd = new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    bank.addMoney(100);
                    bank.viewMoney();
                    System.out.println("\n");

                }
            }
        });

        Thread tsub = new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                while (true) {
                    bank.drawMoney(100);
                    bank.viewMoney();
                    System.out.println("\n");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        });
        tsub.start();
        tadd.start();
    }
}
