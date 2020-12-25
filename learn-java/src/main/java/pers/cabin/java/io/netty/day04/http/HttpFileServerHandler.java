package pers.cabin.java.io.netty.day04.http;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.FullHttpRequest;

public class HttpFileServerHandler extends SimpleChannelInboundHandler<FullHttpRequest> {
    private String url;

    public HttpFileServerHandler(String url) {
        this.url = url;
    }


    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, FullHttpRequest fullHttpRequest) throws Exception {
//        if (fullHttpRequest.getDecoderResult())
    }
}
