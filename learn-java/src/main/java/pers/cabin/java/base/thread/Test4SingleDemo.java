package pers.cabin.java.base.thread;

/**
 * 懒汉式，有线程安全隐患
 * <p>
 * Created by cc on 2016/11/4.
 */
public class Test4SingleDemo {
    private Test4SingleDemo() {
    }

    private static Test4SingleDemo s = null;

    //需要加上同步方式1，变为同步函数
    public static synchronized Test4SingleDemo getInstance() {
        if (s == null) {//->0   ->1
            s = new Test4SingleDemo();
        }
        return s;
    }

    //加上同步方式2，双重判断，提升懒汉式效率
    public static Test4SingleDemo getInstance2() {

        if (s == null) {
            synchronized (Test4SingleDemo.class) {
                if (s == null) {
                    s = new Test4SingleDemo();
                }
            }
        }
        return s;
    }

}

/**
 * 饿汉式
 * 不纯在 线程安全
 */
class SingleDemo2 {

    private SingleDemo2() {
    }

    private static final SingleDemo2 s = new SingleDemo2();

    public static SingleDemo2 getInstance() {
        return s;
    }

}
