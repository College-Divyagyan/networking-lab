package com.lab.lab4;


/*
    Name: Bibash Bogati
    Roll No: 07
 2) WAP to display all the header fields and values from a webpage response.

 */
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class ResponseHeaders {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://www.example.com"); // replace with desired URL
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        for (Map.Entry<String, java.util.List<String>> header : connection.getHeaderFields().entrySet()) {
            System.out.println(header.getKey() + "=" + header.getValue());
        }

        connection.disconnect();
    }
}
