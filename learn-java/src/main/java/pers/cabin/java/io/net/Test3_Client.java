package pers.cabin.java.io.net;

import java.io.*;
import java.net.Socket;

/**
 * TCP传输，客户端建立过程
 * 1.创建tcp客户端socket服务，使用的是socket对象。一般建立sokcet就连接服务对象(即目的地，需要连接的主机)
 * 2.如果连接成功，说明数据通道已经建立。该通道就是Socket流，是底层建立好的。既然是流，说明既有输入，又有输出
 * 想要输入或者输出流对象，可以找socket来获取。getInputStream
 * <p>
 * Created by cc on 2016/11/15.
 */
public class Test3_Client {

    public static void main(String[] args) {

        try {
            System.out.println("正在连接中...");

            Socket socket = new Socket("192.168.1.126", 9999);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            StringBuffer stringBuffer = new StringBuffer();

            String line = null;
            while ((line = in.readLine()) != null) {
                if (line.equals("over")) {
                    break;
                }
                stringBuffer.append(line);
            }
            System.out.println(stringBuffer.toString());
            System.out.println("读取消息完毕...");

//          发送信息
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            String content = "你好！";
            out.write(content);
            out.newLine();
            out.write("over");
            out.flush();
            System.out.println("回复消息完毕...");

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
