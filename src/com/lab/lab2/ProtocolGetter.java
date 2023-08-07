package com.lab.lab2;

/*
Name: Bibash Bogati
Roll No: 07
2. Write a program that checks the protocols a virtual machine support
[ex: http, https, ftp, telnet, gopher, mailto]

*/

import java.net.URL;
import java.net.MalformedURLException;

public class ProtocolGetter {
    public static void main(String[] args) {
        String[] protocols = {"http", "https", "ftp", "telnet", "gopher", "mailto"};

        for (String protocol : protocols) {
            try {
                new URL(protocol, "localhost","");
                System.out.println("Protocol supported: " + protocol);
            } catch (MalformedURLException e) {
                System.err.println("Invalid URL for protocol: " + protocol);
            }
        }
    }
}
