/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chungnh.simple.weather.data.mapper;

import com.chungnh.simple.weather.data.model.Location;
import org.json.simple.JSONObject;

import java.util.HashMap;

/**
 * @author chungnh
 */
public class LocationMapper implements Mapper<Location> {

    @Override
    public Location fromJSON(JSONObject jo) {
        Location location = new Location();
        location.setId((long) jo.get("id"));
        location.setName((String) jo.get("name"));
        location.setLongitude((double) jo.get("longitude"));
        location.setLatitude((double) jo.get("latitude"));
        return location;
    }

    @Override
    public String toJSON(Location location) {
        HashMap<String, Object> object = new HashMap<>();
        object.put("id", location.getId());
        object.put("name", location.getName());
        object.put("latitude", location.getLatitude());
        object.put("longitude", location.getLongitude());
        return new JSONObject(object).toJSONString();
    }
}
