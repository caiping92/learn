package pers.cabin.java.io.netty.day03.demo2;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pers.cabin.java.constants.Constants;

public class ClientTimeHandler extends ChannelHandlerAdapter {
    private static final Logger logger = LoggerFactory.getLogger(ClientTimeHandler.class);
    private byte[] req;
    private int counter;

    public ClientTimeHandler() {
//        req = ("QUERY TIME ORDER"+System.getProperty(Constants.LINE_SEPARATOR)).getBytes();
        String t = "";
        for (int i = 0; i < 1000000; i++) {
            t += "sdfsadfasdfasfdasfdasfasff";
        }
        req = (t + System.getProperty(Constants.LINE_SEPARATOR)).getBytes();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {

//        发送 100 次
        ByteBuf fistMsg = null;
        for (int i = 0; i < 100; i++) {
            fistMsg = Unpooled.buffer(req.length);
            fistMsg.writeBytes(req);
            ctx.writeAndFlush(fistMsg);
        }
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        ByteBuf buf = (ByteBuf) msg;
        byte[] req = new byte[buf.readableBytes()];
        buf.readBytes(req);

        String body = new String(req, "UTF-8");
        System.out.println("Now is Body: " + body + " and counter is " + ++counter);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        logger.warn("Unexcept exception from downStream: " + cause.getMessage());
        ctx.close();
    }
}
