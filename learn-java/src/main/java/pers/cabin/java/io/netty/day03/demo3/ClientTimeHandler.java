package pers.cabin.java.io.netty.day03.demo3;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pers.cabin.java.constants.Constants;

public class ClientTimeHandler extends ChannelHandlerAdapter {
    private static final Logger logger = LoggerFactory.getLogger(ClientTimeHandler.class);
    private int counter;

    public ClientTimeHandler() {
    }

    public void channelActive(ChannelHandlerContext ctx) throws Exception {
//        发送 100 次
        ByteBuf fistMsg = null;
        byte[] req = ("QUERY TIME ORDER" + System.getProperty(Constants.LINE_SEPARATOR)).getBytes();//直接将内容全发送

//        fistMsg = Unpooled.buffer(1024);
//        fistMsg.writeBytes(req);
//        ctx.writeAndFlush(fistMsg);
        for (int i = 0; i < 100; i++) {
            fistMsg = Unpooled.buffer(req.length);
            fistMsg.writeBytes(req);
            ctx.writeAndFlush(fistMsg);
        }
    }

    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        String body = (String) msg;

        System.out.println("The clinet revieve order " + ++counter + " ->" + body);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        logger.warn("Unexcept exception from downStream: " + cause.getMessage());
        ctx.close();
    }
}
