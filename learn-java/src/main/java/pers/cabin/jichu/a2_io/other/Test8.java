package pers.cabin.jichu.a2_io.other;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/**
 * ByteArray    数组型
 * 操作内存中得数据
 * Created by cc on 2016/11/14.
 */
public class Test8 {

    public static void main(String[] args) {

        ByteArrayInputStream bai = new ByteArrayInputStream("abcdefgh".getBytes());

        ByteArrayOutputStream bao = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        int len = 0;
        while ((len = bai.read()) != -1) {
            bao.write(len);
        }
        System.out.println(bao.toString());

    }

}
