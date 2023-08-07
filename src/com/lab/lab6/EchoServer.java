package com.lab.lab6;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/*
    Name: Bibash Bogati
 */
public class EchoServer {
    public static void main(String[] args) {
        try {
            // Create a server socket channel
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress(9999));
            System.out.println("Server started and listening on port 9999...");

            while (true) {
                // Accept client connection
                SocketChannel socketChannel = serverSocketChannel.accept();
                System.out.println("Client connected from: " + socketChannel.getRemoteAddress());

                // Read content from the client
                ByteBuffer buffer = ByteBuffer.allocate(1024);
                socketChannel.read(buffer);
                buffer.flip();
                String content = new String(buffer.array()).trim();
                System.out.println("Received from client: " + content);
                buffer.clear();

                // Write back the same content to the client
                socketChannel.write(ByteBuffer.wrap(content.getBytes()));

                // Close the connection
                socketChannel.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

