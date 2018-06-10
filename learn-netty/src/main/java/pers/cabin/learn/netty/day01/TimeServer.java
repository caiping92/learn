package pers.cabin.learn.netty.day01;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 *
 * @author caiping
 * @date 2018/1/3
 *
 * https://www.cnblogs.com/liuming1992/p/4758532.html
 *
 * 创建ServerSocketChannel
 * 绑定监听，配置TCP参数
 * 创建IO线程，轮询多路复用器Selector
 * 创建Selector，将之前创建的 ServerSocketChannel 注册到 Selector上，监听 SelectionKey.ACCEPT
 * 启动IO线程，轮询Selector.select()方法，轮询就绪Channel
 * 当轮询就绪状态的Channel时，需要对其进行判断，如果是 OP_ACCEPT状态，则新客户端接入，使用ServerSocketChannel.accept（）
 * 方法接收新的客户端
 * 设置新接入客户端链路 SocketChannel 为 非阻塞式，配置其他一些TCP参数
 * 将SocketChannel注册到Selector，监听OP_READ
 * 如果轮询的Channel为OP_READ，则说明SocketChannel中有心得 就绪包，构造ByteBuffer对象读取对象
 * 如果轮询Channel为OP_WRITE，这说明没有发送完，需要继续发送
 */
public class TimeServer {

    public  void bind(int port) {

        //配置NIO线程组
        NioEventLoopGroup boosGroup = new NioEventLoopGroup();
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(boosGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 1024)
                    .childHandler(new ChildChannelHandler());

            //绑定端口，同步等待成功
            ChannelFuture f = bootstrap.bind(port).sync();

            //等待服务端监听端口关闭
            f.channel().closeFuture().sync();

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //退出，释放线程池资源
            boosGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

    /**
     *
     * @author caiping
     * @date 2018/1/3
     */
    private class ChildChannelHandler extends ChannelInitializer<SocketChannel> {
        @Override
        protected void initChannel(SocketChannel socketChannel) throws Exception {
            socketChannel.pipeline().addLast(new TimeServerHandler());
        }
    }
}
