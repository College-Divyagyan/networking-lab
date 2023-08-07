package com.lab.lab2;

/*
Name: Bibash Bogati
Roll No: 07
1. Write a program that splits the parts of a URL.
*/

import java.net.URL;
import java.net.MalformedURLException;


public class URLPARSER {
    public static void main(String[] args) throws MalformedURLException {
        String url = "https://www.google.com/search?q=image&tbm=isch&ved=2ahUKEwj827nasvb3AhV-";
        URL parsedUrl = new URL(url);
        System.out.println("Protocol: " + parsedUrl.getProtocol());
        System.out.println("Host: " + parsedUrl.getHost());
        System.out.println("Path: " + parsedUrl.getPath());
        System.out.println("Query: " + parsedUrl.getQuery());

    }
}
