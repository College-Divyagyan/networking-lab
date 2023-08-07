package com.lab.lab5;

import java.io.*;
import java.net.*;

/*
Name: Bibash Bogati
Roll No: 07
1) WAP to read content from server using socket.
*/

public class SocketClientReadContent {
    public static void main(String[] args) {
        try {
            // Create a socket to connect to the server
            Socket socket = new Socket("time.nist.gov", 13);
            socket.setSoTimeout(15000);
            // Create input and output streams for the socket
            InputStream in = socket.getInputStream();


            String request = "GET / HTTP/1.1\r\nHost: time.nist.gov/\r\n\r\n";
            in.read(request.getBytes());

            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
            in.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
