package com.lab.lab2;


/*
Name: Bibash Bogati
Roll No: 07
4. Write a program for resolving relative URI
*/
import java.net.URI;
import java.net.URISyntaxException;

public class URIRelative {
    public static void main(String[] args) {
        String baseUriString = "https://www.divyagyan.edu.np/";
        String relativeUriString = "wp-content/uploads/2022/08/futsal.jpg";
        try {
            URI baseUri = new URI(baseUriString);
            URI relativeUri = new URI(relativeUriString);
            URI resolvedUri = baseUri.resolve(relativeUri);
            System.out.println(resolvedUri);
        } catch (URISyntaxException e) {
            System.err.println("Invalid URI: " + e.getMessage());
        }
    }
}
