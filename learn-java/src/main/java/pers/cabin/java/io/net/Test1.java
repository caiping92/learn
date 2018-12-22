package pers.cabin.java.io.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by cc on 2016/11/15.
 */
public class Test1 {

    public static void main(String[] args) {

        try {
            InetAddress ip = InetAddress.getByName("127.0.0.1");
//            ip = InetAddress.getLocalHost();
            ip = InetAddress.getByName("www.baidu.com");
            System.out.println(ip.getHostName());
            System.out.println(ip.getCanonicalHostName());
            System.out.println(ip.getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }
}
