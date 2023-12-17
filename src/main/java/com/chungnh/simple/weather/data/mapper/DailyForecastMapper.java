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
import java.util.Map;

/**
 * @author chungnh
 */
public class DailyForecastMapper implements Mapper<Forecast.Daily> {

    @Override
    public Forecast.Daily fromJSON(JSONObject jo) {
        Forecast.Daily daily = new Forecast.Daily();
        System.out.println(jo);
        daily.setTime(MappingUtil.parseLongList((JSONArray) jo.get("time")));
        daily.setWeatherCodes(MappingUtil.parseLongList((JSONArray) jo.get("weather_code")));
        daily.setTemperatureMax(MappingUtil.parseDoubleList((JSONArray) jo.get("temperature_2m_max")));
        daily.setTemperatureMin(MappingUtil.parseDoubleList((JSONArray) jo.get("temperature_2m_min")));
        daily.setPrecipitationSum(MappingUtil.parseDoubleList((JSONArray) jo.get("precipitation_sum")));
        daily.setWindSpeedMax(MappingUtil.parseDoubleList((JSONArray) jo.get("wind_speed_10m_max")));
        daily.setSunrise(MappingUtil.parseLongList((JSONArray) jo.get("sunrise")));
        daily.setSunset(MappingUtil.parseLongList((JSONArray) jo.get("sunset")));
        daily.setRainSum(MappingUtil.parseDoubleList((JSONArray) jo.get("rain_sum")));
        daily.setUvIndexMax(MappingUtil.parseDoubleList((JSONArray) jo.get("uv_index_max")));
        return daily;
    }

    @Override
    public String toJSON(Forecast.Daily daily) {
        Map<String, Object> map = new HashMap<>();
        map.put("time", daily.getTime());
        map.put("weather_code", daily.getWeatherCodes());
        map.put("temperature_2m_max", MappingUtil.anyToJSONArray(daily.getTemperatureMax()));
        map.put("temperature_2m_min", MappingUtil.anyToJSONArray(daily.getTemperatureMin()));
        map.put("uv_index_max", MappingUtil.anyToJSONArray(daily.getUvIndexMax()));
        map.put("precipitation_sum", MappingUtil.anyToJSONArray(daily.getPrecipitationSum()));
        map.put("wind_speed_10m_max", MappingUtil.anyToJSONArray(daily.getWindSpeedMax()));
        map.put("sunrise", MappingUtil.anyToJSONArray(daily.getSunrise()));
        map.put("sunset", MappingUtil.anyToJSONArray(daily.getSunset()));
        map.put("rain_sum", MappingUtil.anyToJSONArray(daily.getRainSum()));
        return new JSONObject(map).toJSONString();
    }

}
