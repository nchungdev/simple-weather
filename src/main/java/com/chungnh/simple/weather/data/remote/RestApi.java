package com.chungnh.simple.weather.data.remote;

import com.chungnh.simple.weather.data.mapper.ForecastMapper;
import com.chungnh.simple.weather.data.mapper.LocationMapper;
import com.chungnh.simple.weather.data.model.Forecast;
import com.chungnh.simple.weather.data.model.Location;
import com.chungnh.simple.weather.utility.task.Observable;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URIBuilder;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RestApi {
    private static final String API_WEATHER = "https://api.open-meteo.com/";
    private static final String API_GEO = "https://geocoding-api.open-meteo.com/";

    //https://api.open-meteo.com/v1/forecast?latitude=52.52&longitude=13.41&current=temperature_2m,precipitation,rain,weather_code&timezone=Asia%2FBangkok

    public static Forecast getWeather(List<NameValuePair> queryMap) throws URISyntaxException {
        String url = buildUrl(API_WEATHER, "v1/forecast", queryMap);
        JSONObject jsonObject = HttpUtil.get(url);
        return jsonObject != null ? new ForecastMapper().fromJSON(jsonObject) : null;
    }

    public static Observable<List<Location>> searchLocation(List<NameValuePair> queryMap) {
        return Observable.fromCallable(() -> {
            JSONObject result = HttpUtil.get(buildUrl(API_GEO, "v1/search", queryMap));
            if (result == null) {
                return Collections.emptyList();
            } else {
                JSONArray results = (JSONArray) result.get("results");
                if (results == null)
                    return Collections.emptyList();
                List<Location> locations = new ArrayList<>();
                LocationMapper parser = new LocationMapper();
                for (Object o : results) {
                    locations.add(parser.fromJSON((JSONObject) o));
                }
                return locations;
            }
        });
    }

    private static String buildUrl(String host, String path, List<NameValuePair> params) throws URISyntaxException {
        URIBuilder uriBuilder = new URIBuilder(host).setPath(path);
        uriBuilder.addParameters(params);
        return uriBuilder.toString().replaceAll("%2C", ",");
    }
}
