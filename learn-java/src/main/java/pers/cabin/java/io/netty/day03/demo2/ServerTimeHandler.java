package pers.cabin.java.io.netty.day03.demo2;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import pers.cabin.java.constants.Constants;

import java.util.Date;

public class ServerTimeHandler extends ChannelHandlerAdapter {

    /**
     * 消息条数记录
     */
    private int counter;

    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf buf = (ByteBuf) msg;
        byte[] req = new byte[buf.readableBytes()];
        buf.readBytes(req);

        String body = new String(req, "UTF-8").substring(0, req.length
                - System.getProperty(Constants.LINE_SEPARATOR).length());   //去掉回车

        System.out.println("The time server recieve order : " + body);

        String respContent = "QUERY TIME ORDER".equalsIgnoreCase(body) ? new Date(System.currentTimeMillis()).toString()
                : "BAD ORDER";
        respContent += System.getProperty(Constants.LINE_SEPARATOR);
        System.out.println("---------------------------------");
        System.out.println("The server receive: " + body + " and counter is " + ++counter);
        System.out.println("---------------------------------");

        ByteBuf resp = Unpooled.copiedBuffer(respContent.getBytes());
        ctx.writeAndFlush(resp);
    }


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
