package com.cabinal.learn.java;

import org.junit.Test;
import pers.cabin.java.StdOut;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

public class ServerSocketChannelTest {

    private String hostname = "127.0.0.1";
    private int port = 8088;

    @Test
    public void blockServer() throws IOException {

        ServerSocketChannel socketChannel = ServerSocketChannel.open();

        socketChannel.bind(new InetSocketAddress(hostname, port));
        while (true) {
            SocketChannel channel = socketChannel.accept();
            StringBuilder receive = new StringBuilder();
            if (channel != null) {
                for (ByteBuffer buffer = ByteBuffer.allocate(1024); channel.read(buffer) != -1; ) {
                    byte[] array = buffer.array();
                    //粘包
                    receive.append(new String(array));
                    buffer.clear();
                }
            }
            StdOut.println("[Receive]: " + receive.toString());
        }

    }

    @Test
    public void blockClient() throws IOException {

        try (SocketChannel clientChannel = SocketChannel.open();) {
            clientChannel.connect(new InetSocketAddress("127.0.0.1", 8088));
            clientChannel.write(ByteBuffer.wrap("hello22 ".getBytes()));
        }
    }


    @Test
    public void nonBlockServer() throws IOException {

        ServerSocketChannel socketChannel = ServerSocketChannel.open();

        socketChannel.bind(new InetSocketAddress(8088));
        socketChannel.configureBlocking(false);


        Selector selector = Selector.open();
        socketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (selector.select() > 0) {

            Iterator<SelectionKey> itr = selector.selectedKeys().iterator();
            while (itr.hasNext()) {

                SelectionKey next = itr.next();
                itr.remove();
                if (next.isReadable()) {
                    SocketChannel channel = (SocketChannel) next.channel();
                    StringBuilder builder = new StringBuilder();
                    ByteBuffer buf = ByteBuffer.allocate(1024);
                    while (channel.read(buf) != -1) {
                        builder.append(new String(buf.array()));
                        buf.clear();
                    }
                    StdOut.println("Server Recieve " + builder.toString());
                } else if (next.isAcceptable()) {
                    StdOut.println("Client accepted");
                    ServerSocketChannel channel = (ServerSocketChannel) next.channel();

                    SocketChannel accept = channel.accept();
                    accept.write(ByteBuffer.wrap("hello client".getBytes()));

                    channel.register(selector, SelectionKey.OP_ACCEPT);

                }

            }
        }
    }

    public void nonBlockClient() throws IOException {


        SocketChannel socketChannel = SocketChannel.open();

        socketChannel.bind(new InetSocketAddress(hostname, port));

        socketChannel.configureBlocking(false);


        Selector selector = Selector.open();
        socketChannel.register(selector, SelectionKey.OP_ACCEPT);

//        selector.se



    }
}
