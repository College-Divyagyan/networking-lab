package com.lab.lab8;

/*
    Name: Bibash Bogati
    Roll No: 07
*/

import java.io.IOException;
import java.net.*;

public class UDPTimeServer {
    public static void main(String[] args) {
        final int SERVER_PORT = 12345;

        try {
            DatagramSocket serverSocket = new DatagramSocket(SERVER_PORT);

            System.out.println("UDP Time Server is running and listening on port " + SERVER_PORT);

            while (true) {
                byte[] requestData = new byte[1024];

                DatagramPacket requestPacket = new DatagramPacket(requestData, requestData.length);

                serverSocket.receive(requestPacket);

                InetAddress clientAddress = requestPacket.getAddress();
                int clientPort = requestPacket.getPort();


                String request = new String(requestData, 0, requestPacket.getLength());

                if (request.equals("Time Request")) {

                    String currentTime = getCurrentTime();

                    byte[] responseData = currentTime.getBytes();


                    DatagramPacket responsePacket = new DatagramPacket(responseData, responseData.length, clientAddress, clientPort);

                    serverSocket.send(responsePacket);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getCurrentTime() {
        return java.time.LocalTime.now().toString();
    }
}
