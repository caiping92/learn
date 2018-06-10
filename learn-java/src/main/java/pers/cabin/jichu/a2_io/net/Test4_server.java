package pers.cabin.jichu.a2_io.net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by cc on 2016/11/16.
 */
public class Test4_server {

    public static void main(String[] args) {

        ServerSocket serverSocket = null;
        Socket accept = null;
        try {
            serverSocket = new ServerSocket(9999);

            while (true) {
                accept = serverSocket.accept();
                new Thread(new Test4_SocketThread(accept));
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                accept.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
