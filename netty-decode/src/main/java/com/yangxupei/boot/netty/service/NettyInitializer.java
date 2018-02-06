package com.yangxupei.boot.netty.service;

import com.yangxupei.boot.netty.decode.SelfDefineDecoder;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.bytes.ByteArrayDecoder;


/**
 * @author : Yang xp
 * Date: 2018/1/30
 * Time: 下午12:00
 * Desc：
 */
public class NettyInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        ChannelPipeline pipeline = socketChannel.pipeline();
        pipeline.addLast("decoder", new SelfDefineDecoder());
        //业务逻辑处理
        pipeline.addLast("handler", new NettyHandler());
    }
}
