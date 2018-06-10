package pers.cabin.learn;

import pers.cabin.learn.netty.day01.TimeServer;

/**
 * Created by caiping on 2018/1/3.
 */
public class TimeServerTest {
    public static void main(String[] args){

        int port = 8080;
        if (null != args && args.length > 0) {
            try {
                port = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
//                port=8080
            }
        }
//        启动服务器
        new TimeServer().bind(port);

    }
}
