package com.lab.lab3;

/*
    Name: Bibash Bogati
    Roll No: 07
    Write a program to implement the CookieStore Methods (add, read, delete) cookies.
*/
import java.io.IOException;
import java.net.*;
import java.util.HashMap;
import java.util.List;

public class CookieGetter {
    public static void main(String[] args) throws URISyntaxException, IOException {
        CookieManager manager = new CookieManager();
        // Using our own class to get the host cookie
        manager.setCookiePolicy(new CookieLooker());

        URI uri_edu_np = new URI("https://tufohss.edu.np");
        URI uri_dot_com = new URI("https://example.com");

        manager.put(uri_edu_np, new HashMap<String, List<String>>(){{
                put("Set-Cookie", List.of("name=value"));
                }});
        System.out.print("For domain: "+uri_edu_np);
        manager.put(uri_dot_com, new HashMap<String, List<String>>(){{
                put("Set-Cookie", List.of("name=value"));
                }});
        System.out.print("For domain: "+uri_dot_com);

        CookieStore store = manager.getCookieStore();
        // Adding the Cookies
        store.add(uri_dot_com, new HttpCookie("name", "monty"));
        // Reading the cookies.
        store.getCookies();
        for (HttpCookie data: store.getCookies()
             ) {
            System.out.println(data);
        }
        // Removing the Cookies.
        for (HttpCookie data: store.getCookies()
             ) {
            store.remove(uri_dot_com,data);
            System.out.println("This cookie has been removed." +store.remove(uri_dot_com,data));
        }


    }


}
