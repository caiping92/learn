package pers.cabin.jichu.a2_nio;

import java.io.*;
import java.net.Socket;

/**
 * TODO some problem has haddpened!
 * Created by caiping on 2017/10/21.
 */
public class Client {


    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("127.0.0.1", 8888);

        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        System.out.println(bufferedReader.readLine());

        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello".getBytes());
        outputStream.flush();


    }
}
