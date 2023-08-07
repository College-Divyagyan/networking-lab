package com.lab.day1;

import java.net.*;
import java.util.Objects;

/*
Name: Bibash Bogati
Roll No: 07
6 WAP to check whether the addresses tu.edu.np and fohss.tu.edu.np are same.

 */
public class AddressChecker {
    public static void main(String[] args) throws UnknownHostException {
        String address1 = "tu.edu.np";
        String address2 = "fohss.tu.edu.np";
        InetAddress inetAddress_1 = InetAddress.getByName(address1);
        InetAddress inetAddress_2 = InetAddress.getByName(address2);
        if (Objects.equals(inetAddress_1.getHostAddress(), inetAddress_2.getHostAddress())) {
            System.out.println(address1 + " IP: " + inetAddress_1.getHostAddress() + " equals " + address2 + " IP: " + inetAddress_2.getHostAddress());
        }
        else {
            System.out.println(address1 + " IP does not matches with " + address2);
        }
    }
}

