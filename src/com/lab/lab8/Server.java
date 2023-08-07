package com.lab.lab8;

/*
    Name: Bibash Bogati
    Roll No: 07
*/

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Base64;

public class Server {
    private static final int SERVER_PORT = 9977;

    public static void main(String[] args) {
        try {
            // Create a server socket
            ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
            System.out.println("Server started, waiting for clients...");

            // Accept a client connection
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected");

            // Initialize input/output streams
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            // Receive the public key from the client
            String encodedKey = in.readLine();
            Key secretKey = new SecretKeySpec(Base64.getDecoder().decode(encodedKey), "AES");

            // Start a separate thread for receiving messages from the client
            Thread receiverThread = new Thread(() -> {
                try {
                    String message;
                    while ((message = in.readLine()) != null) {
                        System.out.println("Client: " + decryptMessage(message, secretKey));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            receiverThread.start();

            // Read messages from the console and send them to the client
            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
            String input;
            while ((input = consoleReader.readLine()) != null) {
                String encryptedMessage = encryptMessage(input, secretKey);
                out.println(encryptedMessage);
            }

            // Close the socket and threads
            clientSocket.close();
            serverSocket.close();
            receiverThread.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String encryptMessage(String message, Key key) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedBytes = cipher.doFinal(message.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    private static String decryptMessage(String encryptedMessage, Key key) throws Exception {
        byte[] encryptedBytes = Base64.getDecoder().decode(encryptedMessage);
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
        return new String(decryptedBytes, StandardCharsets.UTF_8);
    }
}

