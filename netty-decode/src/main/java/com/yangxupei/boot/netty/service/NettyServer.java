package com.yangxupei.boot.netty.service;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author : Yang xp
 * Date: 2018/1/30
 * Time: 上午11:59
 * Desc：
 */
@Slf4j
@Component
public class NettyServer {


    @PostConstruct
    public void startServer() {
        try {
            log.info("netty启动开始");
            EventLoopGroup boosgroup = new NioEventLoopGroup();
            EventLoopGroup workergroup = new NioEventLoopGroup();
            final ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(boosgroup, workergroup);
            bootstrap.channel(NioServerSocketChannel.class);
            bootstrap.childHandler(new NettyInitializer());
            new Thread(() -> {
                ChannelFuture f;
                try {
                    // 服务器绑定端口监听
                    int port = 10002;
                    f = bootstrap.bind(port).sync();
                    f.channel().closeFuture().sync();
                } catch (InterruptedException e) {
                    log.error("netty绑定端口失败：", e);
                }
            }).start();
        } catch (Exception e) {
            log.error("netty绑定端口失败：", e);
        }
        log.info("netty启动成功");
    }

}
