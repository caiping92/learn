package pers.cabin.jichu.a2_nio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by caiping on 2017/10/21.
 */
public class TranditionServer2 {

    public static void main(String[] args) throws IOException {

        ExecutorService executorService = Executors.newCachedThreadPool();

        ServerSocket serverSocket = new ServerSocket(7777);

        System.out.println("服务端启动...");

        while (true) {


            Socket socket = serverSocket.accept();

            executorService.execute(()->{
                System.out.println("有新用户连接...");
                try {
                    InputStream is = socket.getInputStream();
                    byte[] buf = new byte[1024];
                    int len = -1;
                    while ((len = is.read(buf)) != -1) {
                        System.out.println(new String(buf, 0, len));
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                }
            });
        }

    }



}
