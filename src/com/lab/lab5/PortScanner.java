package com.lab.lab5;

import java.io.IOException;
import java.net.*;

/*
    Name: Bibash Bogati
    Roll No: 07
    3) WAP to scan a server for lower 512 available ports.
*/

public class PortScanner {
    public static void main(String[] args) {
        String host = "localhost"; // Change this to the host name or IP address of the server
        int timeout = 1000; // Timeout in milliseconds

        for (int port = 1; port <= 512; port++) {
            try {
                Socket socket = new Socket();
                socket.connect(new InetSocketAddress(host, port), timeout);
                System.out.println("Port " + port + " is open");
                socket.close();
            } catch (IOException e) {
                // Port is closed or unreachable
            }
        }
    }
}
