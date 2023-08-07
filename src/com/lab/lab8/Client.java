package com.lab.lab8;

/*
 Name: Bibash Bogati
 Roll No: 07
* */

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Base64;

public class Client {
    private static final String SERVER_HOST = "localhost";
    private static final int SERVER_PORT = 9977;

    public static void main(String[] args) {
        try {
            // Generate AES key
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(128);
            SecretKey secretKey = keyGenerator.generateKey();

            // Connect to the server
            Socket socket = new Socket(SERVER_HOST, SERVER_PORT);
            System.out.println("Connected to server");

            // Initialize input/output streams
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Send the public key to the server
            out.println(Base64.getEncoder().encodeToString(secretKey.getEncoded()));

            // Start a separate thread for receiving messages from the server
            Thread receiverThread = new Thread(() -> {
                try {
                    String message;
                    while ((message = in.readLine()) != null) {
                        System.out.println("Server: " + decryptMessage(message, secretKey));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            receiverThread.start();

            // Read messages from the console and send them to the server
            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
            String input;
            while ((input = consoleReader.readLine()) != null) {
                String encryptedMessage = encryptMessage(input, secretKey);
                out.println(encryptedMessage);
            }

            // Close the socket and threads
            socket.close();
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
