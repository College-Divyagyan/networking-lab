package com.lab.lab2;

/*
Name: Bibash Bogati
Roll No: 07
5. Write a program to download an object
*/

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class DownloadObject {
    public static void main(String[] args) {
        String url = "https://www.divyagyan.edu.np/wp-content/uploads/2022/08/DSC2382-300x169.jpg";
        try {
            URL objectUrl = new URL(url);
            URLConnection connection = objectUrl.openConnection();
            InputStream inputStream = connection.getInputStream();
            FileOutputStream outputStream = new FileOutputStream("../someonepic.jpg");
            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, length);
            }
            outputStream.close();
            System.out.println("Object downloaded successfully.");
        } catch (IOException e) {
            System.err.println("Error downloading object: " + e.getMessage());
        }
    }
}

