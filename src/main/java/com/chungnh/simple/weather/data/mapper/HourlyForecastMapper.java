/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chungnh.simple.weather.data.mapper;

import com.chungnh.simple.weather.data.model.Forecast;
import com.chungnh.simple.weather.utility.MappingUtil;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.HashMap;

/**
 * @author chungnh
 */
public class HourlyForecastMapper implements Mapper<Forecast.Hourly> {

    @Override
    public Forecast.Hourly fromJSON(JSONObject jo) {
        Forecast.Hourly hourly = new Forecast.Hourly();
        hourly.setDay(MappingUtil.parseLongList((JSONArray) jo.get("is_day")));
        hourly.setTime(MappingUtil.parseLongList((JSONArray) jo.get("time")));
        hourly.setRain(MappingUtil.parseDoubleList((JSONArray) jo.get("rain")));
        hourly.setVisibility(MappingUtil.parseDoubleList((JSONArray) jo.get("visibility")));
        hourly.setWeatherCodes(MappingUtil.parseLongList((JSONArray) jo.get("weather_code")));
        hourly.setTemperature(MappingUtil.parseDoubleList((JSONArray) jo.get("temperature_2m")));
        hourly.setRelativeHumidity(MappingUtil.parseLongList((JSONArray) jo.get("relative_humidity_2m")));
        hourly.setCloudCover(MappingUtil.parseLongList((JSONArray) jo.get("cloud_cover")));
        hourly.setWindSpeed(MappingUtil.parseDoubleList((JSONArray) jo.get("wind_speed_10m")));
        return hourly;
    }

    @Override
    public String toJSON(Forecast.Hourly hourly) {
        HashMap<String, Object> jsonObject = new HashMap<>();
        jsonObject.put("is_day", hourly.isDay());
        jsonObject.put("time", hourly.getTime());
        jsonObject.put("weather_code", hourly.getWeatherCodes());
        jsonObject.put("temperature_2m", hourly.getTemperature());
        jsonObject.put("relative_humidity_2m", MappingUtil.anyToJSONArray(hourly.getRelativeHumidity()));
        jsonObject.put("cloud_cover", MappingUtil.anyToJSONArray(hourly.getCloudCover()));
        jsonObject.put("wind_speed_10m", MappingUtil.anyToJSONArray(hourly.getWindSpeed()));
        jsonObject.put("visibility", MappingUtil.anyToJSONArray(hourly.getVisibility()));
        jsonObject.put("rain", MappingUtil.anyToJSONArray(hourly.getRain()));
        return new JSONObject(jsonObject).toJSONString();
    }
}
