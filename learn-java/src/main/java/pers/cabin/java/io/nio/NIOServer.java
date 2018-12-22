package pers.cabin.java.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * Created by caiping on 2017/10/21.
 */
public class NIOServer {

    private Selector selector;//通道，管理器

    //test
    public static void main(String[] args) {

        NIOServer nioServer = new NIOServer();
        try {
            nioServer.init(8888);
            nioServer.listen();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void init(int port) throws IOException {

        ServerSocketChannel channel = ServerSocketChannel.open();

        channel.configureBlocking(false);//非阻塞
        channel.socket().bind(new InetSocketAddress(port));

        selector = Selector.open();

        channel.register(selector, SelectionKey.OP_ACCEPT);//连接
        System.out.println("服务启动...");
    }

    /**
     * 监听
     */
    public void listen() {

        //轮询 selectionKey
        while (true) {//通过选择器 获取事件
            try {
                //等待客户端连接
                selector.select();//多路复用
                System.out.println("客户端连接...");

                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                ;
                for (SelectionKey seleKey = null; iterator.hasNext(); ) {
                    seleKey = iterator.next();//请求
                    //处理请求
                    handler(seleKey);
                    //移除请求
                    iterator.remove();

                }

            } catch (IOException e) {
                e.printStackTrace();
            }


        }

    }

    private void handler(SelectionKey seleKey) throws IOException {
        if (seleKey.isAcceptable()) {//是监听事件
            //处理客户端事件
            ServerSocketChannel channel = (ServerSocketChannel) seleKey.channel();

            SocketChannel socketChannel = channel.accept();
            socketChannel.configureBlocking(false);
            socketChannel.register(selector, SelectionKey.OP_READ);//接收客户端发送的信息，并给通道设置读的权限
        } else if (seleKey.isReadable()) {//处理读的事件
            //处理读的事件
            SocketChannel socketChannel = (SocketChannel) seleKey.channel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);//初始化容量
            int len = socketChannel.read(byteBuffer);
            if (len > 0) {
                System.out.println(new String(byteBuffer.array(), 0, len));
            } else {//没有数据
                System.out.println("客户端关闭...");

                //清除事件
                seleKey.cancel();
            }

        }

    }
}
