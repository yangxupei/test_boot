package com.yangxupei.boot.netty.service;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;

/**
 * @author : Yang xp
 * Date: 2018/1/30
 * Time: 下午12:00
 * Desc：
 */
@Slf4j
public class NettyHandler extends SimpleChannelInboundHandler<byte[]> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, byte[] msg) throws Exception {
        log.info("netty服务的接受消息:{}",new String(msg));
    }
}
