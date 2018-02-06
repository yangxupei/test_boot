package com.yangxupei.boot.netty.decode;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @author : Yang xp
 * Date: 2018/1/31
 * Time: 上午9:48
 * Desc：
 */
@Slf4j
public class SelfDefineDecoder extends ByteToMessageDecoder {

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf bufferIn, List<Object> out) throws Exception {
        if (bufferIn.readableBytes() < 4) {
            return;
        }

    }
}
