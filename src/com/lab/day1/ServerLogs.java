package com.lab.day1;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/*
 Name: Bibash Bogati
 Roll No: 07
11) Wap to process the server log files.
 */
public class ServerLogs {
    private static final String LOG_FILE = "D:\\myfiles\\college\\Network_Prog\\Code\\networks_lab_1\\server.txt";
    public static void main(String[] args) {
        Map<String, Integer> ipCounts = new HashMap<>();
        Map<String, Integer> urlCounts = new HashMap<>();
        int totalRequests = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(LOG_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                String ipAddress = parts[0];
                String dateTime = parts[5].substring(1) + " " + parts[4].substring(0, parts[4].length() - 1);
                String requestUrl = parts[6];
                int statusCode = Integer.parseInt(parts[8]);
                String userAgent = line.substring(line.indexOf("\"") + 1, line.lastIndexOf("\""));

                ipCounts.put(ipAddress, ipCounts.getOrDefault(ipAddress, 0) + 1);
                urlCounts.put(requestUrl, urlCounts.getOrDefault(requestUrl, 0) + 1);
                totalRequests++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Total requests: " + totalRequests);
        System.out.println("Unique IP addresses: " + ipCounts.size());
        System.out.println("Unique URLs: " + urlCounts.size());

        for (Map.Entry<String, Integer> entry : ipCounts.entrySet()) {
            System.out.println("IP address " + entry.getKey() + " made " + entry.getValue() + " requests.");
        }

        for (Map.Entry<String, Integer> entry : urlCounts.entrySet()) {
            System.out.println("URL " + entry.getKey() + " was requested " + entry.getValue() + " times.");
        }
    }
}
