package pers.cabin.jichu.a2_nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by caiping on 2017/10/18.
 */
public class Demo1 {

    public static void main(String[] args) {


        test2();

    }

    private static void test2() {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile("D:/tmp/t_1.txt", "rw");

            FileChannel fileChannel = randomAccessFile.getChannel();
//            fileChannel.transferFrom()
            ByteBuffer buf = ByteBuffer.allocate(48);
            int bytesRead = fileChannel.read(buf);
            while (bytesRead != -1) {
                System.out.println("Read " + bytesRead);
                buf.flip();


                while (buf.hasRemaining()) {
                    System.out.print((char) buf.get());
                }
                buf.clear();
                bytesRead = fileChannel.read(buf);

                randomAccessFile.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void test1_1() {
        ByteBuffer buffer = ByteBuffer.allocate(48);

//        int bytesRead =  inChannel.read(buffer);
        //扫描缓冲区，但必须保持在bufferFull（）方法被调用之前状态相同
//        bufferFull
    }

    private static void test1_0() {
        ByteBuffer buffer = ByteBuffer.allocate(48);

//        int bytesRead =  inChannel.read(buffer);
    }

}
