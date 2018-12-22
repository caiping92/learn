package pers.cabin.java.io.net;

import java.net.Socket;

/**
 * Created by cc on 2016/11/16.
 */
public class Test4_SocketThread implements Runnable {

    private Socket accept;

    public Test4_SocketThread(Socket accept) {
        this.accept = accept;
    }

    @Override
    public void run() {
        doSomething();
    }

    /**
     * 服务器 处理的相关逻辑
     */
    private synchronized void doSomething() {
        System.out.println(accept.getInetAddress().getHostAddress() + "连接成功...");

        //服务端业务代码
        System.out.println("处理一些事情中...");
    }
}
