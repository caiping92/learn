package com.cabinal.learn.java;

import org.junit.Test;
import pers.cabin.java.StdOut;

import java.nio.ByteBuffer;

public class BufferTest {


    @Test
    public void testBuffer() {


//        ByteBuffer buffer = ByteBuffer.allocate(8);
        ByteBuffer buffer = ByteBuffer.allocateDirect(8);

        StdOut.println(buffer.isDirect());

        StdOut.print("buf put begin ");
        StdOut.println(buffer.toString());

        String v = "abc";
        buffer.put(v.getBytes());
        StdOut.println(buffer.toString());

        buffer.flip();
        StdOut.println(buffer.toString());

        byte b = buffer.get();

        buffer.isDirect();
        StdOut.println(buffer.toString());

        buffer.flip();
        StdOut.println(buffer.toString());


    }

}
