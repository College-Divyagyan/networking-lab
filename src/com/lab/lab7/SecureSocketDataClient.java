package com.lab.lab7;

/*
    Name: Bibash Bogati
    Roll No: 07
*/

import java.io.*;
import javax.net.ssl.*;

public class SecureSocketDataClient {
    public static void main(String[] args) {
        String serverHost = "tu.edu.np";
        int serverPort = 443; // HTTPS default port

        try {
            // Create SSL context
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, getTrustManager(), new java.security.SecureRandom());

            // Create socket factory
            SSLSocketFactory socketFactory = sslContext.getSocketFactory();

            // Create a socket
            SSLSocket socket = (SSLSocket) socketFactory.createSocket(serverHost, serverPort);
            System.out.println("Connected to " + serverHost);

            // Perform handshake
            socket.startHandshake();

            // Send HTTP GET request
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            writer.write("GET / HTTP/1.1\r\nHost: " + serverHost + "\r\n\r\n\n");
            writer.flush();

            // Receive and print response
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            // Close streams and socket
            reader.close();
            writer.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static TrustManager[] getTrustManager() {
        return new TrustManager[] { new X509TrustManager() {
            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                return null;
            }

            public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType) {
            }

            public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType) {
            }
        } };
    }
}
