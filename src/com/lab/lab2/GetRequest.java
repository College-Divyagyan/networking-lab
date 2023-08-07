package com.lab.lab2;//package com.network_lab_2;
//
//
///*
//Name: Bibash Bogati
//Roll No: 07
// 7. Write a program that communicating with Server-Side Programs Through GET.
//*/
//
//import java.net.*;
//import java.io.*;
//
//
//public class GetRequest {
//    public static void main(String[] args) {
//        String urlStr = "http://example.com/get_request.php?param1=value1&param2=value2";
//
//        try {
//            // Create a URL object
//            URL url = new URL(urlStr);
//
//            // Open a connection to the URL
//            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//
//            // Set the request method to GET
//            conn.setRequestMethod("GET");
//
//            // Read the response from the server
//            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//            String line;
//            while ((line = reader.readLine()) != null) {
//                System.out.println(line);
//            }
//            reader.close();
//
//            // Disconnect from the server
//            conn.disconnect();
//
//        } catch (Exception e) {
//            System.out.println("Exception: " + e.getMessage());
//        }
//    }
//}
