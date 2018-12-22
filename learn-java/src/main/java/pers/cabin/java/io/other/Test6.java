package pers.cabin.java.io.other;

import java.io.*;

/**
 * Created by cc on 2016/11/14.
 */
public abstract class Test6 {
    public Test6() {
    }

    public static void test1() {
        DataOutputStream dos = null;
        try {
            dos = new DataOutputStream(new FileOutputStream(new File(("D:\\temp\\ddataos.txt"))));
            dos.writeInt(1);
            dos.writeUTF("你好");
            dos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (dos != null) {
                try {
                    dos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    /**
     * 具有顺序性
     */
    public static void test2() {
        try {
            DataInputStream dis = new DataInputStream(new FileInputStream(new File(("D:\\temp\\ddataos.txt"))));

            int i = dis.readInt();
            System.out.println("i=" + i);

            String s = dis.readUTF();
            System.out.println("s= " + s);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        test1();
        System.out.println("----------------");
        test2();
    }
}
