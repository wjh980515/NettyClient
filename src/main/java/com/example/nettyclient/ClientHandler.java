package com.example.nettyclient;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class ClientHandler extends SimpleChannelInboundHandler<Msg> {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Msg msg = Msg.newBuilder().setId(1).setContent("Hello!").build();
        log.info("发送的信息:{}",msg);
        ctx.writeAndFlush(msg);
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Msg msg) throws Exception {
        log.info("收到的消息:{}",msg);

    }
}
