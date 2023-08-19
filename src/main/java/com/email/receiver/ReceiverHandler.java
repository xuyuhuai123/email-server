package com.email.receiver;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

public class ReceiverHandler extends SimpleChannelInboundHandler<FullHttpRequest> {

    @Override
    protected void messageReceived(ChannelHandlerContext ctx, FullHttpRequest request) throws Exception {
        System.out.println(request.content().toString(CharsetUtil.UTF_8));
        FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK);

        String respMsg = "hello, world!";

        ByteBuf respBuf = Unpooled.copiedBuffer(respMsg.getBytes(CharsetUtil.UTF_8));

        response.content().writeBytes(respBuf);

        ctx.writeAndFlush(response).addListener(ChannelFutureListener.CLOSE);
    }
}
