package pers.cabin.basic;

import pers.cabin.vo.Person;

import java.util.Random;

/**
 * Created by caiping on 2017/10/21.
 */
public class Test_jvm {

    public static void main(String[] args){

//        test2();

        test3();
//        test5();

    }

    private static void test4() {
        for (int i= 0; i<100;i++) {
            new Thread(new Task4()).start();
        }

    }


    private static void test3() {
        Task3 t = new Task3();
        for (int i= 0; i<100;i++) {
            new Thread(t).start();
        }

    }

    private static void test2() {

//        Person p = new Person();
        for (int i= 0; i<2;i++) {
//            new Thread(new Task("task_"+i,p)).start();
            new Thread(new Task2()).start();
        }


    }

    private static void test1() {

        Person p = new Person();
        for (int i= 0; i<2;i++) {
            new Thread(new Task("task_"+i,p)).start();
        }


    }

    private static void test() {
        Person p1 = new Person();
        p1.setName("old");
        System.out.println(p1.getName());

        t(p1);

        System.out.println(p1.getName());
    }

    public static void t(Person p) {
//        p = new Person();
        p.setName("m");

    }
}


class Task4 implements Runnable {

//    private volatile static int count;
    private static int count;

    @Override
    public void run() {
        add();
    }
    private synchronized static void add() {
        for (int i=0;i<10;i++) {
            count++;
            System.out.println("count+="+count);
        }
    }
}

class Task3 implements Runnable {

    private volatile static int count;
    @Override
    public void run() {
        add();
    }
    private static void add() {
        for (int i=0;i<10;i++) {
            count++;
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("count+="+count);
        }
    }
}

class Task2 implements Runnable {

    //    private volatile static int count;
    private static int count;

    @Override
    public void run() {
        add();
    }
    private static void add() {
        for (int i=0;i<10;i++) {
            count++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("count+="+count);
        }
    }
}

class Task implements Runnable {

    private volatile Person p;

    private String name;

    public Task(String name,Person p) {
        this.name = name;
        this.p = p;

    }

    @Override
    public void run() {
        doSmth();
    }

    public void doSmth(){
        try {
            Thread.sleep(10+new Random().nextInt(10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        p.setName("t_" + System.currentTimeMillis());

        System.out.println(this.name+"--"+p.getName());
    }
}
