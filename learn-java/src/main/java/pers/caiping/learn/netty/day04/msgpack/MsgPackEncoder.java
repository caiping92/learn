package pers.caiping.learn.netty.day04.msgpack;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import org.msgpack.MessagePack;

/**
 *
 * 继承MessageToByteEncoder，MessageToByteEncoder ，
 * 将Object 类型 编码为byte数组，然后写到 ByteBuf中
 *
 */
public class MsgPackEncoder extends MessageToByteEncoder<Object> {

    @Override
    protected void encode(ChannelHandlerContext ctx, Object msg, ByteBuf out) throws Exception {
        MessagePack messagePack = new MessagePack();
        byte[] raw = messagePack.write(msg);//Serialize 序列化
        out.writeBytes(raw);
    }
}
