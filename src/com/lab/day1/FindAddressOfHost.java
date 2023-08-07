package com.lab.day1;

import java.net.*;
/*
Name: Bibash Bogati
Roll No: 07
1 WAP to find the address of fohss.tu.edu.np
*/
public class FindAddressOfHost {
    public static void main(String[] args) {
        try {
            InetAddress address = InetAddress.getByName("fohss.tu.edu.np");
            System.out.println("Hostname: " + address.getHostName() + " Ip Address: " + address.getHostAddress());
        }catch (UnknownHostException e){
            System.out.println("Could not find the fohss.tu.edu.np.");
        }
    }
}
