package com.lab.day1;

import java.net.*;
/*
Name: Bibash Bogati
2 WAP to check whether the address is IPv4 or IPv6.
Roll No: 07
 */

public class CheckIpType {
    public static void main(String[] args) {
        try {
            InetAddress address = InetAddress.getByName("fohss.tu.edu.np");
            if (address instanceof Inet4Address){
                System.out.println("IP Address Version: 4");

            }else{
                System.out.println("IP Address Version: 6");
            }
//            System.out.println("Hostname: " + address.getHostName() + " Ip Address: " + address.getHostAddress());
        } catch (UnknownHostException e) {
            System.out.println("Could not find the fohss.tu.edu.np.");
        }
    }
}
