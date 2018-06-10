package pers.cabin.jichu.a2_io.net;

import java.io.IOException;
import java.net.*;

/**
 * Created by cc on 2016/11/15.
 */
public class Test2_UDPServer {

    public static void main(String[] args) {

        try {
            DatagramSocket datagramSocket = new DatagramSocket();

            //发送内容，用 DatagramPacket
            String content = "Hello, I'm comming.";
            InetAddress ip = InetAddress.getByName("192.168.1.126");
            byte[] buf = content.getBytes();
            DatagramPacket datagramPacket = new DatagramPacket(buf, 0, buf.length, ip, 9999);
            datagramSocket.send(datagramPacket);

            datagramSocket.close();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }

    }

}
