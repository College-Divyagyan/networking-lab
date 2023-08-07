package com.lab.lab5;

/*
Name: Bibash Bogati
Roll No: 07
2) WAP to write content into server using socket.

*/

import java.io.*;
import java.net.*;

public class SocketClientWriteContent {

    public static void main(String[] args) {
        try {
            // Create a socket to connect to the server
            Socket socket = new Socket("time.nist.gov", 13);

            // Create input and output streams for the socket
            InputStream in = socket.getInputStream();
            OutputStream out = socket.getOutputStream();

            // Write content to the server
            String content = "Hello, server!";
            out.write(content.getBytes());

            // Read the response from the server
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            // Close the streams and the socket
            reader.close();
            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
