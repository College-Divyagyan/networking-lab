package com.lab.lab2;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/*
Name: Bibash Bogati
Roll No: 07
3. Write a program to download a web page of a given web address  [ex: www.divyagyan.edu.np]

*/
public class WebPage {
    public static void main(String[] args) {
        String url = "https://www.divyagyan.edu.np/";

        try {
            URL webpage = new URL(url);
            URLConnection connection = webpage.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
            }
            in.close();
        } catch (IOException e) {
            System.err.println("Error downloading web page: " + e.getMessage());
        }
    }
}
