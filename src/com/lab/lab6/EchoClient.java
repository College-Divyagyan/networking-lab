package com.lab.lab6;

/*
 Name: Bibash Bogati
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;


public class EchoClient {
    public static void main(String[] args) {
        try {
            // Create a socket channel and connect to the server
            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.connect(new InetSocketAddress("localhost", 9999));
            System.out.println("Connected to the server.");

            // Read input from the console
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter message: ");
            String message = reader.readLine();

            // Write the message to the server
            socketChannel.write(ByteBuffer.wrap(message.getBytes()));

            // Read the echoed message from the server
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            socketChannel.read(buffer);
            buffer.flip();
            String echoedMessage = new String(buffer.array()).trim();
            System.out.println("Echoed message from server: " + echoedMessage);
            buffer.clear();

            // Close the connection
            socketChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

