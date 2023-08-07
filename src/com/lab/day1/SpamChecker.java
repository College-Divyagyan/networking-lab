package com.lab.day1;



import java.net.InetAddress;
import java.net.UnknownHostException;

/*
Name: Bibash Bogati
Roll No: 07
10. WAP to demonstrate SPAM checking.
 */

public class SpamChecker {
    private static final String SPAMHAUS_DNSBLS = "sbl.spamhaus.org";

    public static boolean isSpam(String ipAddress) {
        try {
            String reversedIp = new StringBuilder(ipAddress).reverse().toString();
            String query = reversedIp + "." + SPAMHAUS_DNSBLS;
            InetAddress[] result = InetAddress.getAllByName(query);
            return result != null && result.length > 0;
        } catch (UnknownHostException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        String ipAddress = "149.102.138.19";
        if (isSpam(ipAddress)) {
            System.out.println("IP address " + ipAddress + " is a known spammer.");
        } else {
            System.out.println("IP address " + ipAddress + " is not a known spammer.");
        }
    }
}
