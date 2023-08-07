package com.lab.lab7;

/*
Name:Aayush Nepal
Roll No: 07
 */
import javax.net.ssl.*;
import java.io.*;
import java.security.KeyStore;

public class SecureTimeClient {

    private static final String SERVER_HOST = "localhost";
    private static final int SERVER_PORT = 4345;

    public static void main(String[] args) {
        try {
            // Load the keystore containing the client's truststore
            KeyStore trustStore = KeyStore.getInstance("JKS");
            trustStore.load(new FileInputStream("C:\\Users\\Aayush Nepal\\IdeaProjects\\Java\\src\\com\\networks_lab_7\\server_keystore.jks"), "hello1".toCharArray());

            // Create and configure SSL context with the client's truststore
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance("SunX509");
            trustManagerFactory.init(trustStore);

            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, trustManagerFactory.getTrustManagers(), null);

            // Create SSL socket factory
            SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();

            // Create client socket and connect to the server
            SSLSocket clientSocket = (SSLSocket) sslSocketFactory.createSocket(SERVER_HOST, SERVER_PORT);

            // Create reader to receive the server response
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            // Read the server response
            String response = in.readLine();
            System.out.println("Response from server: " + response);

            // Close the reader and the client socket
            in.close();
            clientSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
