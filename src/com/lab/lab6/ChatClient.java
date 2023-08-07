package com.lab.lab6;


/*
    Name: Bibash Bogati
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class ChatClient {
    public static void main(String[] args) {
        try {
            // Create a socket channel and connect to the server
            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.connect(new InetSocketAddress("localhost", 9999));
            System.out.println("Connected to the server.");

            // Start a new thread to handle server messages
            Thread thread = new Thread(() -> handleServerMessages(socketChannel));
            thread.start();

            // Read input from the console and send messages to the server
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                String message = reader.readLine();
                ByteBuffer buffer = ByteBuffer.wrap(message.getBytes());
                socketChannel.write(buffer);
                buffer.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleServerMessages(SocketChannel socketChannel) {
        try {
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            while (true) {
                // Read content from the server
                buffer.clear();
                int bytesRead = socketChannel.read(buffer);
                if (bytesRead == -1) {
                    // Server disconnected
                    System.out.println("Disconnected from the server.");
                    socketChannel.close();
                    break;
                }

                buffer.flip();
                String message = new String(buffer.array(), 0, bytesRead).trim();
                System.out.println("Received from server: " + message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
