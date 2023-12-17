/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chungnh.simple.weather.utility;

import com.chungnh.simple.weather.data.model.ListDaily;
import com.chungnh.simple.weather.data.model.ListHourly;
import com.chungnh.simple.weather.data.model.Forecast;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author chungnh
 */
public class MappingUtil {

    public static List<Long> parseLongList(JSONArray array) {
        List<Long> result = new ArrayList<>();
        if (array == null) return result;
        for (Object o : array) {
            if (o instanceof Long l) {
                result.add(l);
            }
        }
        return result;
    }

    public static List<String> parseStringList(JSONArray array) {
        List<String> result = new ArrayList<>();
        if (array == null) return result;
        for (Object o : array) {
            if (o instanceof String str) {
                result.add(str);
            }
        }
        return result;
    }

    public static List<Double> parseDoubleList(JSONArray array) {
        List<Double> result = new ArrayList<>();
        if (array == null) return result;
        for (Object o : array) {
            if (o instanceof Double d) {
                result.add(d);
            }
        }
        return result;
    }


    public static JSONObject toJSONObject(Object str) {
        if (str instanceof JSONObject) {
            return (JSONObject) str;
        }
        JSONParser parser = new JSONParser();
        try {
            return (JSONObject) parser.parse(String.valueOf(str));
        } catch (ParseException ex) {
            Logger.getLogger(MappingUtil.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public static JSONArray anyToJSONArray(List<?> any) {
        JSONArray jsonArray = new JSONArray();
        jsonArray.addAll(any);
        return jsonArray;
    }

    public static ListHourly toList(Forecast.Hourly hourly) {
        ListHourly items = new ListHourly();
        int size = hourly.getTime().size();
        for (int i = 0; i < size; i++) {
            ListHourly.Item item = new ListHourly.Item();
            item.setDay(hourly.isDay().get(i) == 1);
            item.setTime(hourly.getTime().get(i));
            item.setRain(hourly.getRain().get(i));
            item.setWeatherCode(hourly.getWeatherCodes().get(i));
            item.setCloudCover(hourly.getCloudCover().get(i));
            item.setTemperature(hourly.getTemperature().get(i));
            item.setRelativeHumidity(hourly.getRelativeHumidity().get(i));
            item.setVisibility(hourly.getVisibility().get(i));
            item.setWindSpeed(hourly.getWindSpeed().get(i));
            items.add(item);
        }
        return items;
    }

    public static ListDaily toList(Forecast.Daily daily) {
        ListDaily listDaily = new ListDaily();
        int size = daily.getTime().size();
        for (int i = 0; i < size; i++) {
            listDaily.add(dailyToSingle(daily, i));
        }
        return listDaily;
    }

    public static ListDaily.Item dailyToSingle(Forecast.Daily daily, int index) {
        ListDaily.Item item = new ListDaily.Item();
        item.setSunrise(daily.getSunrise().get(index));
        item.setSunset(daily.getSunset().get(index));
        item.setTime(daily.getTime().get(index));
        item.setRainSum(daily.getRainSum().get(index));
        item.setWeatherCode(daily.getWeatherCodes().get(index));
        item.setPrecipitationSum(daily.getPrecipitationSum().get(index));
        item.setUvIndexMax(daily.getUvIndexMax().get(index));
        item.setWindSpeedMax(daily.getWindSpeedMax().get(index));
        item.setTemperatureMax(daily.getTemperatureMax().get(index));
        item.setTemperatureMin(daily.getTemperatureMin().get(index));
        return item;
    }
}
