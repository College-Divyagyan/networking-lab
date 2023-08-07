package com.lab.lab5;

/*
    Name: Bibash Bogati
    Roll No: 07
    5) WAP a JAVA SWING application to perform as WHOIS client.
*/

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.*;

public class WhoisClient extends JFrame implements ActionListener {
    private JTextField domainField;
    private JTextArea responseArea;

    public WhoisClient() {
        super("WHOIS Client");

        // Create and add the components
        JPanel panel = new JPanel(new BorderLayout());
        domainField = new JTextField();
        JButton queryButton = new JButton("Query");
        queryButton.addActionListener(this);
        responseArea = new JTextArea();
        responseArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(responseArea);
        panel.add(domainField, BorderLayout.NORTH);
        panel.add(queryButton, BorderLayout.EAST);
        panel.add(scrollPane, BorderLayout.CENTER);
        getContentPane().add(panel);

        // Set the window properties
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent event) {
        // Get the domain name to query
        String domain = domainField.getText().trim();
        if (domain.length() == 0) {
            JOptionPane.showMessageDialog(this, "Please enter a domain name to query", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Query the WHOIS server
        try (Socket socket = new Socket("whois.internic.net", 43)) {
            OutputStream out = socket.getOutputStream();
            out.write((domain + "\r\n").getBytes());
            out.flush();

            InputStream in = socket.getInputStream();
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            int n;
            byte[] data = new byte[4096];
            while ((n = in.read(data, 0, data.length)) != -1) {
                buffer.write(data, 0, n);
            }

            String response = new String(buffer.toByteArray());
            responseArea.setText(response);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        WhoisClient client = new WhoisClient();
        client.setVisible(true);
    }
}
