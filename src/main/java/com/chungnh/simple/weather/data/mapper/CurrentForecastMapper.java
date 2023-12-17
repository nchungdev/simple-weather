/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chungnh.simple.weather.data.mapper;

import com.chungnh.simple.weather.data.model.Forecast;
import org.json.simple.JSONObject;

import java.util.HashMap;

/**
 * @author chungnh
 */
public class CurrentForecastMapper implements Mapper<Forecast.Current> {

    @Override
    public Forecast.Current fromJSON(JSONObject jo) {
        Forecast.Current current = new Forecast.Current();
        current.setDay((long) jo.get("is_day") == 1);
        current.setTime((long) jo.get("time"));
        current.setRain((double) jo.get("rain"));
        current.setPrecipitation((double) jo.get("precipitation"));
        current.setWeatherCode((long) jo.get("weather_code"));
        current.setTemperature((double) jo.get("temperature_2m"));
        current.setWindSpeed((double) jo.get("wind_speed_10m"));
        current.setRelativeHumidity((long) jo.get("relative_humidity_2m"));
        return current;
    }

    @Override
    public String toJSON(Forecast.Current current) {
        HashMap<String, Object> jsonObject = new HashMap<>();
        jsonObject.put("is_day", current.isDay());
        jsonObject.put("time", current.getTime());
        jsonObject.put("rain", current.getRain());
        jsonObject.put("precipitation", current.getPrecipitation());
        jsonObject.put("weather_code", current.getWeatherCode());
        jsonObject.put("temperature_2m", current.getTemperature());
        jsonObject.put("wind_speed_10m", current.getWindSpeed());
        jsonObject.put("relative_humidity_2m", current.getRelativeHumidity());
        return new JSONObject(jsonObject).toJSONString();
    }
}
