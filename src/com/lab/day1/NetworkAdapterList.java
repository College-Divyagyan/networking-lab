package com.lab.day1;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
/*
Name: Bibash Bogati
Roll No: 07
7. WAP to list the names and display name of all network adapters in the machine.

 */
public class NetworkAdapterList {
    public static void main(String[] args) {
        try {
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            while (interfaces.hasMoreElements()) {
                NetworkInterface networkInterface = interfaces.nextElement();
                System.out.println("Name: " + networkInterface.getName());
                System.out.println("Display Name: " + networkInterface.getDisplayName());
                System.out.println();
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
}

