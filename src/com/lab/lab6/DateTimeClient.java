package com.lab.lab6;

/*
    Name: Bibash Bogati.
*/

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class DateTimeClient {
    public static void main(String[] args) {
        try {
            // Create a socket channel and connect to the server
            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.connect(new InetSocketAddress("localhost", 57951));
            System.out.println("Connected to the server.");

            // Read time from the server
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            socketChannel.read(buffer);
            buffer.flip();
            String timeString = new String(buffer.array()).trim();
            System.out.println("Server time: " + timeString);
            buffer.clear();

            // Close the connection
            socketChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
