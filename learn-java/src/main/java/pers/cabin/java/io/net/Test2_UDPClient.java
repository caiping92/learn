package pers.cabin.java.io.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * UDP接收端
 * 1.建立UDP socket
 * 2.创建数据包，用于存储接受到的数据，方便用数据报对象的方法解析这些数据
 * 3.使用socket服务的recieve方法接受数据存储到数据包这中
 * 4.通过数据报的方法解析数据报中的额数据
 * 5.关闭资源
 * <p>
 * <p>
 * Created by cc on 2016/11/15.
 */
public class Test2_UDPClient {

    public static void main(String[] args) {
        try {
            //TODO 建立UDP socket服务
            DatagramSocket datagramSocket = new DatagramSocket(9999);

            byte[] buf = new byte[4096];
            DatagramPacket datagramPacket = new DatagramPacket(buf, 0, buf.length);

            datagramSocket.receive(datagramPacket);

            System.out.println(datagramPacket.getAddress().getHostName());
            System.out.println(new String(datagramPacket.getData(), 0, datagramPacket.getLength()));

            datagramSocket.close();

        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
