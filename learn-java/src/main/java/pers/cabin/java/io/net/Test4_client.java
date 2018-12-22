package pers.cabin.java.io.net;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Created by cc on 2016/11/16.
 */
public class Test4_client {

    public static void main(String[] args) {

        String host = "192.168.1.126";
        try {
            Socket socket = new Socket(InetAddress.getByName(host), 9999);

            //TODO 一些业务

            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
