package com.lab.day1;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;
/*
Name: Bibash Bogati
Roll No: 07
9. WAP to check if a host is reachable or not.
 */

public class HostAvailability {
    public static void main(String[] args) throws IOException {
        System.out.println("Enter the hostname: ");
        Scanner hostname = new Scanner(System.in);
        InetAddress address = InetAddress.getByName(hostname.nextLine());
        if (address.isReachable(5000)) {
            System.out.println(address.getHostName().replace(".com.np", "") + " is reachable.");
        } else {
            System.out.println(address.getHostName() + " is not reachable.");
        }

    }
}



