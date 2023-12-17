package com.chungnh.simple.weather.data.local;

public class DbDefines {
    public interface Location extends Table {

        static String name() {
            return "location";
        }

        String NAME = "name";
        String LATITUDE = "latitude";
        String LONGITUDE = "longitude";
        String JSON = "json";
        String TIMESTAMP = "timestamp";
    }

    public interface Weather extends Table {
        static String name() {
            return "weather";
        }

        String LATITUDE = "latitude";
        String LONGITUDE = "longitude";
        String JSON = "json";
        String TIMESTAMP = "timestamp";
    }
}
