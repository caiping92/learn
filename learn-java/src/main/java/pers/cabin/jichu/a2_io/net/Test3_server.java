package pers.cabin.jichu.a2_io.net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 建立TCP服务端的思路
 * 1. 通过ServerSocket对象创建ServerSocket对象
 * 2. 通过serverSocket获取Socket对象
 * 3. 通过socket获取对象的输入输出流
 * Created by cc on 2016/11/15.
 */
public class Test3_server {

    private static final Object obj = new Test3_server();

    public Test3_server() {
    }

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket accept = null;
        BufferedReader in = null;
        BufferedWriter out = null;
        StringBuffer stringBuffer = null;
        try {
            serverSocket = new ServerSocket(9999);
            synchronized (obj) {
                accept = serverSocket.accept();
                System.out.println(accept.getInetAddress().getHostName() + "连接...");

                out = new BufferedWriter(new OutputStreamWriter(accept.getOutputStream()));
                String content = "你好，欢迎来到Xx1号！";
                out.write(content);
                out.newLine();
                out.write("over");
                out.newLine();
                out.flush();
                System.out.println("回复消息完毕...");

                in = new BufferedReader(new InputStreamReader(accept.getInputStream()));
                stringBuffer = new StringBuffer();
                String line;
                while ((line = in.readLine()) != null) {
                    if (line.equals("over")) {
                        break;
                    }
                    stringBuffer.append(line + "\r\n");
                }
                System.out.println(stringBuffer.toString());

            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (accept != null) {
                    accept.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
