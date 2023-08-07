package com.lab.lab6;

/*
    Name: Bibash Bogati
 */

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
    private static List<SocketChannel> clientList = new ArrayList<>();

    public static void main(String[] args) {
        try {
            // Create a server socket channel
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress(9999));
            System.out.println("Server started and listening on port 9999...");

            while (true) {
                // Accept client connection
                SocketChannel socketChannel = serverSocketChannel.accept();
                clientList.add(socketChannel);
                System.out.println("Client connected from: " + socketChannel.getRemoteAddress());

                // Start a new thread to handle client messages
                Thread thread = new Thread(() -> handleClientMessages(socketChannel));
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleClientMessages(SocketChannel socketChannel) {
        try {
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            while (true) {
                // Read content from the client
                buffer.clear();
                int bytesRead = socketChannel.read(buffer);
                if (bytesRead == -1) {
                    // Client disconnected
                    System.out.println("Client disconnected: " + socketChannel.getRemoteAddress());
                    socketChannel.close();
                    clientList.remove(socketChannel);
                    break;
                }

                buffer.flip();
                String message = new String(buffer.array(), 0, bytesRead).trim();
                System.out.println("Received from client " + socketChannel.getRemoteAddress() + ": " + message);

                // Broadcast the message to all connected clients
                broadcastMessage(socketChannel, message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void broadcastMessage(SocketChannel sender, String message) {
        ByteBuffer buffer = ByteBuffer.wrap(message.getBytes());
        for (SocketChannel client : clientList) {
            if (client != sender) {
                try {
                    client.write(buffer);
                    buffer.rewind();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
