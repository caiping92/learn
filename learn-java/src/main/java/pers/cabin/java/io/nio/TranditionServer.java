package pers.cabin.java.io.nio;

import pers.cabin.java.io.nio.task.Test1Server;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * Created by caiping on 2017/10/21.
 */
public class TranditionServer {

    public static void main(String[] args) throws IOException {


        ServerSocket ss = new ServerSocket(8080);
        new Thread(new Test1Server(ss)).start();
        System.out.println("服务器已经启动...");

    }


}
