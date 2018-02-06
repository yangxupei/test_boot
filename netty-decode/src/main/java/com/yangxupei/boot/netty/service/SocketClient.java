package com.yangxupei.boot.netty.service;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author : Yang xp
 * Date: 2018/1/31
 * Time: 上午9:24
 * Desc：
 */
public class SocketClient {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1",10002);
        OutputStream outputStream = socket.getOutputStream();
        StringBuilder builder = new StringBuilder(1029);
        for (int i = 0;i<1028;i++){
            builder.append("1");
        }
        outputStream.write(builder.toString().getBytes());
//        outputStream.write("0005".getBytes());
        outputStream.flush();
        outputStream.close();
    }

}
