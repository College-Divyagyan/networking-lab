package com.lab.lab5;

/*
    Name: Bibash Bogati
    Roll No: 07
    4) WAP to read the various socket options from your socket.

*/

import java.net.*;

public class SocketOptions {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket();

        // Set some socket options
        socket.setSoTimeout(5000);
        socket.setTcpNoDelay(true);
        socket.setKeepAlive(true);
        socket.setReuseAddress(true);
        socket.setReceiveBufferSize(8192);
        socket.setSendBufferSize(8192);

        // Get and print the socket options
        System.out.println("SO_TIMEOUT: " + socket.getSoTimeout());
        System.out.println("TCP_NODELAY: " + socket.getTcpNoDelay());
        System.out.println("SO_KEEPALIVE: " + socket.getKeepAlive());
        System.out.println("SO_REUSEADDR: " + socket.getReuseAddress());
        System.out.println("SO_RCVBUF: " + socket.getReceiveBufferSize());
        System.out.println("SO_SNDBUF: " + socket.getSendBufferSize());

        socket.close();
    }
}
