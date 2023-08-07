package com.lab.lab6;


/*
Name: Bibash Bogati
 */
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;

import  java.util.Date;

import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class DateTimeServer {
    public static void main(String[] args) {
        // new Server Socket
        ServerSocket server = null;
        try {
            server = new ServerSocket(0);
            System.out.println("The is running on port: "+server.getLocalPort());
            while(true) {
                System.out.println("Waiting for the client.");
                Socket socket = server.accept();
                System.out.println("Connected to the client: "+socket.toString());
                OutputStream out = socket.getOutputStream();
                Writer writer = new OutputStreamWriter(out);
                Date date = new Date();

                writer.write(date.toString() + "\r\n");
                writer.flush();
                writer.close();
                System.out.println("Written to client and closed.");
            }

        } catch (Exception e){
            System.out.println(e);
        }
    }
}
