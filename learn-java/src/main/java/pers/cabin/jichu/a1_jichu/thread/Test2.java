package pers.cabin.jichu.a1_jichu.thread;

import pers.cabin.jichu.a1_jichu.thread.myThread.Demo2NumberMinus;
import pers.cabin.jichu.a1_jichu.thread.resouces.Data;
import pers.cabin.jichu.a1_jichu.thread.myThread.Demo2NumberAdd;

/**
 * Created by cc on 2016/11/3.
 */
public class Test2 {

    public static void main(String[] args) {

        Data data = new Data(10); //两个线程调用的target都需要操作的资源（resouces）
        Demo2NumberAdd add = new Demo2NumberAdd(data);//增加的target
        Demo2NumberMinus minus = new Demo2NumberMinus(data);//减少的target

        //两个增加的线程
        new Thread(add).start();
        new Thread(add).start();
        //开启两个减少的两个线程
        new Thread(minus).start();
        new Thread(minus).start();
    }

}
