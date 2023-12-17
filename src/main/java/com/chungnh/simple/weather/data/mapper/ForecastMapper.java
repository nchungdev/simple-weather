/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chungnh.simple.weather.data.mapper;

import com.chungnh.simple.weather.data.model.Forecast;
import com.chungnh.simple.weather.utility.MappingUtil;
import org.json.simple.JSONObject;

import java.util.HashMap;

/**
 * @author chungnh
 */
public class ForecastMapper implements Mapper<Forecast> {

    @Override
    public Forecast fromJSON(JSONObject jo) {
        Forecast forecast = new Forecast();
        if (jo.containsKey("hourly")) {
            forecast.setHourly(new HourlyForecastMapper().fromJSON(MappingUtil.toJSONObject(jo.get("hourly"))));
        }
        if (jo.containsKey("daily")) {
            forecast.setDaily(new DailyForecastMapper().fromJSON(MappingUtil.toJSONObject(jo.get("daily"))));
        }
        if (jo.containsKey("current")) {
            forecast.setCurrent(new CurrentForecastMapper().fromJSON(MappingUtil.toJSONObject(jo.get("current"))));
        }
        forecast.setLatitude((double) jo.get("latitude"));
        forecast.setLongitude((double) jo.get("longitude"));
        return forecast;
    }

    @Override
    public String toJSON(Forecast forecast) {
        HashMap<String, Object> jsonObject = new HashMap<>();
        jsonObject.put("latitude", forecast.getLatitude());
        jsonObject.put("longitude", forecast.getLongitude());
        jsonObject.put("current", new CurrentForecastMapper().toJSON(forecast.getCurrent()));
        jsonObject.put("hourly", new HourlyForecastMapper().toJSON(forecast.getHourly()));
        jsonObject.put("daily", new DailyForecastMapper().toJSON(forecast.getDaily()));
        return new JSONObject(jsonObject).toJSONString();
    }
}
