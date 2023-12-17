package com.chungnh.simple.weather.data.remote;

import com.chungnh.simple.weather.data.model.Forecast;
import com.chungnh.simple.weather.data.model.Location;
import com.chungnh.simple.weather.data.model.Weather;
import com.chungnh.simple.weather.utility.task.Observable;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

public class ForecastRepository {

    public ForecastRepository() {
    }

    public Observable<Weather> getWeather(Location location) {
        return Observable.fromCallable(() -> {
            Weather weather = new Weather();
            weather.setLocation(location);
            Forecast forecast = RestApi.getWeather(createQueryParams(location));
            if (forecast != null) {
                forecast.setLatitude(location.getLatitude());
                forecast.setLongitude(location.getLongitude());
            }
            weather.setForecast(forecast);
            return weather;
        });
    }

    // https://api.open-meteo.com/v1/forecast?latitude=20.47366&longitude=106.02292
    // &current=temperature_2m,precipitation,rain,weather_code,is_day
    // &hourly=temperature_2m,relative_humidity_2m,rain,weather_code,cloud_cover,visibility,wind_speed_10m,is_day
    // &daily=weather_code,temperature_2m_max,temperature_2m_min,sunrise,sunset,uv_index_max,precipitation_sum,rain_sum,wind_speed_10m_max
    // &timeformat=unixtime
    private List<NameValuePair> createQueryParams(Location location) {
        List<NameValuePair> nameValuePairs = new ArrayList<>();
        nameValuePairs.add(new BasicNameValuePair("latitude", String.valueOf(location.getLatitude())));
        nameValuePairs.add(new BasicNameValuePair("longitude", String.valueOf(location.getLongitude())));
        nameValuePairs.add(new BasicNameValuePair("current", "temperature_2m,precipitation,rain,weather_code,is_day,wind_speed_10m,relative_humidity_2m"));
        nameValuePairs.add(new BasicNameValuePair("hourly", "temperature_2m,relative_humidity_2m,rain,weather_code,cloud_cover,visibility,wind_speed_10m,is_day"));
        nameValuePairs.add(new BasicNameValuePair("daily", "weather_code,temperature_2m_max,temperature_2m_min,sunrise,sunset,uv_index_max,precipitation_sum,rain_sum,wind_speed_10m_max"));
        nameValuePairs.add(new BasicNameValuePair("timeformat", "unixtime"));
        return nameValuePairs;
    }
}
