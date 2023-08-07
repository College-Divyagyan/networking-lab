package com.lab.lab7;

/*
Name: Bibash Bogati
Roll No: 07
 */

import javax.net.ssl.*;
import java.io.*;
import java.security.KeyStore;

public class SecureChatClient {

    private static final String SERVER_HOST = "localhost";
    private static final int SERVER_PORT = 3373;
    private static final String TRUSTSTORE_FILE = "C:\\Users\\Aayush Nepal\\IdeaProjects\\Java\\src\\com\\networks_lab_7\\server_keystore.jks";
    private static final String TRUSTSTORE_PASSWORD = "hello1";

    public static void main(String[] args) {
        try {
            // Load the truststore containing the server's certificate
            char[] truststorePassword = TRUSTSTORE_PASSWORD.toCharArray();
            KeyStore trustStore = KeyStore.getInstance("JKS");
            trustStore.load(new FileInputStream(TRUSTSTORE_FILE), truststorePassword);

            // Create and configure SSL context with the client's truststore
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance("SunX509");
            trustManagerFactory.init(trustStore);

            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, trustManagerFactory.getTrustManagers(), null);

            // Create SSL socket factory
            SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();

            // Create client socket and connect to the server
            SSLSocket clientSocket = (SSLSocket) sslSocketFactory.createSocket(SERVER_HOST, SERVER_PORT);

            // Create a new thread to read and display messages from the server
            ChatClientReader clientReader = new ChatClientReader(clientSocket);
            clientReader.start();

            // Read user input and send messages to the server
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            String message;
            while ((message = userInput.readLine()) != null) {
                out.println(message);
            }

            // Close the socket and clean up
            clientSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

