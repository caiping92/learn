package pers.cabin.jichu.a2_nio.task;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Calendar;

public class Test1Server implements Runnable {

    private ServerSocket serverSocket;

    public Test1Server(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Socket accept = serverSocket.accept();
                doService(accept);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void doService(Socket accept) throws IOException {
        if (accept == null) {
            return;
        }

        String request = null;
        String response = "hello "+ Calendar.getInstance().getTime();

        InputStream inputStream = accept.getInputStream();
        byte[] buf = new byte[1024];
        int len=-1;
        while ((len =inputStream.read(buf)) !=-1) {
            request += new String(buf, 0, len);
        }
        System.out.println(request);

        //返回
        OutputStream outputStream = accept.getOutputStream();
        outputStream.write(response.getBytes());
        outputStream.flush();

        inputStream.close();
        outputStream.close();
        accept.close();
        System.out.println("acccept is close...");
    }
}