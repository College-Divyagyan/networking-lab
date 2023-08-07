package com.lab.lab7;

/*
Name:Aayush Nepal
Roll No: 07
 */

import javax.net.ssl.*;
import java.io.*;
import java.security.KeyStore;
import java.util.Date;

public class SecureTimeServer {

    private static final int PORT = 4345;
    private static final String KEYSTORE_PASSWORD = "hello1";

    public static void main(String[] args) {
        try {
            // Load the keystore containing the server's private key and certificate
            char[] keystorePassword = KEYSTORE_PASSWORD.toCharArray();
            KeyStore keyStore = KeyStore.getInstance("JKS");
            keyStore.load(new FileInputStream("C:\\Users\\Aayush Nepal\\IdeaProjects\\Java\\src\\com\\networks_lab_7\\server_keystore.jks"), keystorePassword);

            // Create and configure SSL context
            SSLContext sslContext = SSLContext.getInstance("TLS");
            KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance("SunX509");
            keyManagerFactory.init(keyStore, keystorePassword);
            sslContext.init(keyManagerFactory.getKeyManagers(), null, null);

            // Create SSL server socket factory
            SSLServerSocketFactory sslServerSocketFactory = sslContext.getServerSocketFactory();

            // Create server socket
            SSLServerSocket serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(PORT);

            System.out.println("Secure Time Server is running on port " + PORT);

            while (true) {
                // Wait for client connection
                SSLSocket clientSocket = (SSLSocket) serverSocket.accept();

                // Handle client request
                handleClientRequest(clientSocket);

                // Close the client socket
                clientSocket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void handleClientRequest(SSLSocket clientSocket) throws IOException {
        try {
            // Create writer to send response to the client
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            // Get the current time and send it to the client
            Date currentTime = new Date();
            out.println("Current time: " + currentTime);

            // Flush and close the writer
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
