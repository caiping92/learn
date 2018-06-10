package pers.cabin.learn;

import pers.cabin.learn.netty.day01.TimeClient;

/**
 * Created by caiping on 2018/1/3.
 */
public class TimeClientTest {
    public static void main(String[] args) throws InterruptedException {
        new TimeClient().connect("127.0.0.1",8080);
    }
}
