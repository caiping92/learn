package pers.cabin.java.io.netty.day03.demo3;

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

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        System.out.println(">>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<");

        String body = (String) msg;
        System.out.println("The time server recieve order : " + body);

        String respContent = "QUERY TIME ORDER".equalsIgnoreCase(body) ? new Date(System.currentTimeMillis()).toString()
                : "BAD ORDER";
        respContent += System.getProperty(Constants.LINE_SEPARATOR);

        System.out.println("The server receive: " + ++counter + "->" + body);

        ByteBuf resp = Unpooled.copiedBuffer(respContent.getBytes());
        ctx.writeAndFlush(resp);
    }


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
