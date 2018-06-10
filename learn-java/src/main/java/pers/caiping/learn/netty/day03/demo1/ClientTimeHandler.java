package pers.caiping.learn.netty.day03.demo1;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClientTimeHandler extends ChannelHandlerAdapter {
    private static final Logger logger = LoggerFactory.getLogger(ClientTimeHandler.class);
    private final ByteBuf fistMsg;

    public ClientTimeHandler() {
        byte[] req = "QUERY TIME ORDER".getBytes();
        fistMsg = Unpooled.buffer(req.length);
        fistMsg.writeBytes(req);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush(fistMsg);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        ByteBuf buf = (ByteBuf) msg;
        byte[] req = new byte[buf.readableBytes()];
        buf.readBytes(req);

        String body = new String(req, "UTF-8");
        System.out.println("Now is Body: " + body);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        logger.warn("Unexcept exception from downStream: " + cause.getMessage());
        ctx.close();
    }
}
