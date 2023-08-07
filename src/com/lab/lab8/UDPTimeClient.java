package com.lab.lab8;

/*
    Name: Bibash Bogati
    Roll No: 07
*/

import java.io.IOException;
import java.net.*;

public class UDPTimeClient {
    public static void main(String[] args) {
        final int SERVER_PORT = 12345;

        try {

            DatagramSocket clientSocket = new DatagramSocket();


            InetAddress serverAddress = InetAddress.getByName("localhost");


            byte[] requestData = "Time Request".getBytes();


            DatagramPacket requestPacket = new DatagramPacket(requestData, requestData.length, serverAddress, SERVER_PORT);


            clientSocket.send(requestPacket);


            byte[] responseData = new byte[1024];
            DatagramPacket responsePacket = new DatagramPacket(responseData, responseData.length);


            clientSocket.receive(responsePacket);


            String response = new String(responseData, 0, responsePacket.getLength());


            System.out.println("Server Response: " + response);

            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
