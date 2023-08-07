package com.lab.lab7;

/*
Name: Bibash Bogati
Roll No: 07
 */
import javax.net.ssl.SSLSocket;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChatClientReader extends Thread {
    private SSLSocket clientSocket;

    public ChatClientReader(SSLSocket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            // Read messages from the server
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String message;
            while ((message = in.readLine()) != null) {
                // Display received messages
                System.out.println("Received from server: " + message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
