/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chungnh.simple.weather.data.remote;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 * @author chungnh
 */
public class HttpUtil {

    public static JSONObject get(String urlStr) {
        try {
            return get(new URL(urlStr));
        } catch (MalformedURLException e) {
            return null;
        }
    }

    public static JSONObject get(URL url) {
        HttpURLConnection conn = null;
        try {
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            if (conn.getResponseCode() == 200) {
                InputStream inputStream = conn.getInputStream();
                StringBuilder result = new StringBuilder();
                try (Reader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
                    int c;
                    while ((c = reader.read()) != -1) {
                        result.append((char) c);
                    }
                }
                return toJSONObject(result.toString());
            } else {
                System.out.println("Error: Could not connet to API");
                return null;
            }
        } catch (IOException e) {
            return null;
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
    }

    private static JSONObject toJSONObject(String str) {
        JSONParser parser = new JSONParser();
        try {
            return (JSONObject) parser.parse(String.valueOf(str));
        } catch (ParseException ex) {
            return null;
        }
    }
}
