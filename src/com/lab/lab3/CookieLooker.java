package com.lab.lab3;

/*
 Name: Bibash Bogati
 Roll No: 07
 Write a program that shows a simple CookiePolicy that
 blocks cookies from any .edu.np domains, but allows others.
*/

import java.net.CookiePolicy;
import java.net.HttpCookie;
import java.net.URI;

// Only allowing the .com.np domain to set the cookie and .edu.np domain are restricted.
public class CookieLooker implements CookiePolicy {
    @Override
    public boolean shouldAccept(URI uri, HttpCookie cookie) {
        boolean flag;
        String message;
        if (uri.getHost().endsWith(".edu.np")) {
            message = "The cookie block for this domain.";
            System.out.println(message);
            flag = false;
        } else {
            message = "\nThe cookie allowed for this domain.";
            System.out.println(message);
            flag = true;
        }

        return flag;
    }
}






