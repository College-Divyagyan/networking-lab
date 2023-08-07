package com.lab.day1;

import java.net.*;
import java.util.Scanner;
/*
 Name: Bibash Bogati
 Roll No: 07
 8) WAP to find the IPV4 and IPV6 of a given host.

 */
public class HostAddressFinder {
    public static void main(String[] args) throws UnknownHostException {
        System.out.println("Enter a host name: ");
        Scanner hostname = new Scanner(System.in);
        InetAddress address = InetAddress.getByName(hostname.nextLine());
        System.out.println("Host name: " + address.getHostName());
        System.out.println("IP address: " + address.getHostAddress());
        if (address instanceof Inet6Address) {
            System.out.println("IPv6 address: " + address.getHostAddress());
        } else if (address instanceof Inet4Address) {
            System.out.println("IPv4 address: " + address.getHostAddress());
        }

    }
}
