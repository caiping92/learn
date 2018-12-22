package pers.cabin.java.thread;

/**
 * a.ThreadLocal与同步机制都是为了解决多线程中相同变量的访问冲突问题
 * b.前者采用以”空间换时间”的方法，后者采用以”时间换空间”的方式
 * Created by caiping on 2017/9/22.
 */
public class Bank2 {

    private static ThreadLocal<Integer> count = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };

    public void addMone(int money) {

        count.set(count.get() + money);

        System.out.println(System.currentTimeMillis() + " 存进： " + money);
    }

    public void viewMoney() {
        System.out.println(System.currentTimeMillis() + " 剩下：" + count.get());

    }
}
