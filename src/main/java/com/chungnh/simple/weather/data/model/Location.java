/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chungnh.simple.weather.data.model;

/**
 * @author chungnh
 * <p>
 * "id": 6301170,
 * "name": "Hanoi / Gialam",
 * "latitude": 21.04097,
 * "longitude": 105.88601,
 * "elevation": 15,
 * "feature_code": "AIRP",
 * "country_code": "VN",
 * "timezone": "Asia/Bangkok",
 * "country_id": 1562822,
 * "country": "Vietnam"
 */
public class Location {
    private long id;
    private String name;
    private double latitude;
    private double longitude;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "Location{" + "name=" + name + ", latitude=" + latitude + ", longitude=" + longitude + '}';
    }

    public boolean equals(double latitude, double longitude) {
        return getLatitude() == latitude && getLongitude() == longitude;
    }
}
