package com.chungnh.simple.weather.view.itf;

import com.chungnh.simple.weather.data.model.Weather;

import java.util.List;

public interface WeatherView extends View {
    void showRecentData(List<Weather> results);

    void showData(Weather result);

    void showError(String message);
}
