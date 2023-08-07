package com.lab.lab8;

/*
    Name: Bibash Bogati
    Roll No: 07
*/

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.charset.StandardCharsets;

public class TimeClient_c {
    private static final String SERVER_HOST = "localhost";
    private static final int SERVER_PORT = 4345;

    public static void main(String[] args) {
        try {
            DatagramChannel channel = DatagramChannel.open();

            String requestMessage = "TIME";
            ByteBuffer buffer = ByteBuffer.wrap(requestMessage.getBytes(StandardCharsets.UTF_8));

            channel.send(buffer, new InetSocketAddress(SERVER_HOST, SERVER_PORT));
            buffer.clear();

            channel.receive(buffer);
            buffer.flip();

            String responseMessage = StandardCharsets.UTF_8.decode(buffer).toString();
            System.out.println("Server time: " + responseMessage);

            channel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

