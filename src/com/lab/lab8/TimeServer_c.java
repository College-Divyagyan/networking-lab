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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeServer_c {
    private static final int SERVER_PORT = 4345;

    public static void main(String[] args) {
        try {
            DatagramChannel channel = DatagramChannel.open();
            channel.bind(new InetSocketAddress(SERVER_PORT));
            System.out.println("Server started, waiting for clients...");

            ByteBuffer buffer = ByteBuffer.allocate(1024);

            while (true) {
                buffer.clear();
                InetSocketAddress clientAddress = (InetSocketAddress) channel.receive(buffer);
                buffer.flip();

                String requestMessage = StandardCharsets.UTF_8.decode(buffer).toString().trim();
                if (requestMessage.equalsIgnoreCase("TIME")) {
                    String time = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
                    buffer.clear();
                    buffer.put(time.getBytes(StandardCharsets.UTF_8));
                    buffer.flip();

                    channel.send(buffer, clientAddress);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

