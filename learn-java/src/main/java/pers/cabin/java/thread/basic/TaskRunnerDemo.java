package pers.cabin.java.thread.basic;

public class TaskRunnerDemo {
    public static void main(String[] args) {
        new Thread(new TaskRunner()).start();
    }
}
