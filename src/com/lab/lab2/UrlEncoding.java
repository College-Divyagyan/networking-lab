package com.lab.lab2;
/*
Name: Bibash Bogati
Roll No: 07
6. Write a program to demonstrate the x-www-form-urlencoded strings

*/
import java.net.URLEncoder;
public class UrlEncoding {
    public static void main(String[] args) {
        try {
            // Encode a string
            // Spaces with commas and exclamation.
            String originalString = "Hello, world!";
            String encodedString = URLEncoder.encode(originalString, "UTF-8");
            System.out.println("Encoded string: " + encodedString);
            // Using astriek and percentage.
            String originalString_1 = "%Hello*world%";
            String encodedString_1 = URLEncoder.encode(originalString_1, "UTF-8");
            System.out.println("Encoded string: " + encodedString_1);
            // Using operators such as (+).
            String originalString_2 = "Hello+world";
            String encodedString_2 = URLEncoder.encode(originalString_2, "UTF-8");
            System.out.println("Encoded string: " + encodedString_2);
            // Using colons.
            String originalString_3 = "Hello:world";
            String encodedString_3 = URLEncoder.encode(originalString_3, "UTF-8");
            System.out.println("Encoded string: " + encodedString_3);
            // Using periods or dot.
            String originalString_4 = "Hello.world";
            String encodedString_4 = URLEncoder.encode(originalString_4, "UTF-8");
            System.out.println("Encoded string: " + encodedString_4);
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
