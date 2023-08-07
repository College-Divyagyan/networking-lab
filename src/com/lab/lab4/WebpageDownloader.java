package com.lab.lab4;


/*
    Name: Bibash Bogati
    Roll No: 07
    1) WAP to download a webpage using URLConnection.
 */
import java.io.*;
import java.net.*;

public class WebpageDownloader {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.example.com"); // replace with desired URL
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                response.append(line+ "\n");
            }
            reader.close();

            System.out.println(response.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
