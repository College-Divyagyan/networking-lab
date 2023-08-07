package com.lab.day1;

import java.net.*;

/*
Name: Bibash Bogati
Roll No: 07
4 WAP to find the canonical and host name of a given IP.

 */
public class FindCNAME {
    public static void main(String[] args) throws UnknownHostException {
//        String ip_address = "104.21.19.231";
        byte[] ip_address = new byte[]{104, 21, 19, (byte) 231};
        InetAddress inetAddress = InetAddress.getByAddress("facebook.com", ip_address);
        System.out.println("CNAME: " + inetAddress.getCanonicalHostName() + "\nHostName: " + inetAddress.getHostName());
    }
}
