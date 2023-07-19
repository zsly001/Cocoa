package com.cocoa.net.sever;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class NioNoneBlockServer {

    public static final int PORT = 8090;

    public void start() throws Exception{
        SocketAddress serverAddr = new InetSocketAddress(PORT);
        ServerSocketChannel channel = ServerSocketChannel.open();
        channel.configureBlocking(false);
        channel.bind(serverAddr);
        while (true){
            SocketChannel newChannel = channel.accept();
            if(null!=newChannel){
                ByteBuffer buffer = ByteBuffer.allocate(1024);
                newChannel.configureBlocking(false);
                while (true){
                    System.out.println("come new socket-channel");
                    if(!newChannel.isOpen()){
                        break;
                    }
                    while (newChannel.read(buffer)>0){
                        buffer.flip();
                        byte[] bf = new byte[buffer.limit()];
                        buffer.get(bf);
                        System.out.println(new String(bf));
                        buffer.clear();
                    }
                    System.out.println("new channel loop...");
                    Thread.sleep(1000);
                }
            }

            //newChannel.

            System.out.println("loop...");
            Thread.sleep(1000);
        }


    }

    public static void main(String[] args) {
        try {
            NioNoneBlockServer server = new NioNoneBlockServer();
            server.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
