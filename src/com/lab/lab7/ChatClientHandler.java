package com.lab.lab7;
/*
Name: Bibash Bogati
Roll No: 07
 */
import javax.net.ssl.SSLSocket;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChatClientHandler extends Thread {
    private SSLSocket clientSocket;

    public ChatClientHandler(SSLSocket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            // Read messages from the client
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String message;
            while ((message = in.readLine()) != null) {
                // Process the received message as needed (e.g., broadcast to other clients)
                System.out.println("Received from client: " + message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

