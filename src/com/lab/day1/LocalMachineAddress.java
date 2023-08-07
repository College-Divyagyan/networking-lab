package com.lab.day1;

import java.net.*;

/*
Name: Bibash Bogati
Roll No: 07
3 WAP to find the name and IP address of local machine.
 */
public class LocalMachineAddress {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress hostname = InetAddress.getLocalHost();
        System.out.println("Hostname: " + hostname.getHostName() + "\nIp Address: " + hostname.getHostAddress());
    }
}
