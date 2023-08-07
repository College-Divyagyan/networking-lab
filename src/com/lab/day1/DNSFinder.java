package com.lab.day1;

import java.net.*;
/*
 Name: Bibash Bogati
 Roll No: 07
 5. WAP to find all the addresses of dns.google.com

 */
public class DNSFinder {
    public static void main(String[] args) {
        String domain = "dns.google.com";
        try {
            InetAddress[] inetAddresses = InetAddress.getAllByName(domain);
            System.out.println("IP addresses of " + domain + ":");
            for (InetAddress inetAddress : inetAddresses) {
                System.out.println(inetAddress.getHostAddress());
            }
        } catch (UnknownHostException e) {
            System.out.println("Invalid domain");
        }
    }
}


