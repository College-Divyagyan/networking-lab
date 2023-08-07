package com.lab.lab4;

/*
    Name: Bibash Bogati
    Roll No: 07
    3) WAP to find out the content type, content length and last modified and access date of a URL.

*/
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

public class URLMetadata {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://www.example.com"); // replace with desired URL
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        String contentType = connection.getContentType();
        int contentLength = connection.getContentLength();
        long lastModified = connection.getLastModified();
        long date = connection.getDate();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String lastModifiedDate = dateFormat.format(new Date(lastModified));
        String accessDate = dateFormat.format(new Date(date));

        System.out.println("Content Type: " + contentType);
        System.out.println("Content Length: " + contentLength);
        System.out.println("Last Modified: " + lastModifiedDate);
        System.out.println("Access Date: " + accessDate);

        connection.disconnect();
    }
}
