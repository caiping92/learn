package com.cabinal.learn.java;

import org.junit.Test;
import pers.cabin.java.StdOut;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FIleChannelTest {


    @Test
    public void testInputStreamChannel() throws IOException {


        String src = "E:\\workspace\\learn\\learn-java\\src\\main\\resouces\\sql\\SQL基础.txt";
        String dst = "D:/tmpdir/stream-channel.txt";

        try (
                FileInputStream inpuStream = new FileInputStream(src);
                FileOutputStream outputStream = new FileOutputStream(dst);

                FileChannel readChannel = inpuStream.getChannel();
                FileChannel writeChannel = outputStream.getChannel()
        ) {
            ByteBuffer buf = ByteBuffer.allocate(1024);
            while ((readChannel.read(buf) != -1)) {
                buf.flip();
                writeChannel.write(buf);
                buf.clear();
            }
        }
    }


    @Test
    public void testFileChannel() throws IOException {

        String src = "E:\\workspace\\learn\\learn-java\\src\\main\\resouces\\sql\\SQL基础.txt";
        String dst = "D:/tmpdir/file-channel.txt";
        try (FileChannel readChannel = FileChannel.open(
                Paths.get(src),
                StandardOpenOption.READ
        );
             FileChannel writeChannel = FileChannel.open(
                     Paths.get(dst),
                     StandardOpenOption.WRITE,
//                     StandardOpenOption.CREATE
//                     StandardOpenOption.CREATE_NEW
                     StandardOpenOption.TRUNCATE_EXISTING
             );
        ) {
            for (ByteBuffer buffer = ByteBuffer.allocate(1024);
                 readChannel.read(buffer) != -1; ) {
                buffer.flip();
                writeChannel.write(buffer);
                buffer.clear();
            }


        }
    }


    @Test
    public void testMappedChannel() throws IOException {


        String src = "E:\\workspace\\learn\\learn-java\\src\\main\\resouces\\sql\\SQL基础.txt";
        String dst = "D:/tmpdir/file-map-channel.txt";
        try (FileChannel readChannel = FileChannel.open(
                Paths.get(src),
                StandardOpenOption.READ
        );
             FileChannel writeChannel = FileChannel.open(
                     Paths.get(dst),
                     StandardOpenOption.WRITE,
                     StandardOpenOption.READ,
                     StandardOpenOption.CREATE
//                     StandardOpenOption.CREATE_NEW
//                     StandardOpenOption.TRUNCATE_EXISTING
             );
        ) {
            long size = readChannel.size();
            StdOut.println("Read Channel size " + size);
            MappedByteBuffer mapBuf = readChannel.map(FileChannel.MapMode.READ_ONLY, 0, size);
            writeChannel.write(mapBuf);

        }


    }

    @Test
    public void testChannelTransfer() throws IOException {


        String src = "E:\\workspace\\learn\\learn-java\\src\\main\\resouces\\sql\\SQL基础.txt";
        String dst = "D:/tmpdir/file-transfer-channel.txt";


       try( FileChannel sourceChannel = FileChannel.open(Paths.get(src), StandardOpenOption.READ);
            FileChannel destChannel = FileChannel.open(Paths.get(dst), StandardOpenOption.WRITE, StandardOpenOption.CREATE);
       ) {
           long l = destChannel.transferFrom(sourceChannel, 0, sourceChannel.size());
           StdOut.println("trans size: " + l);
       }
    }
}
