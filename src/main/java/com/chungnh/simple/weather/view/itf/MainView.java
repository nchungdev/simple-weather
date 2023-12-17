package com.chungnh.simple.weather.view.itf;

import com.chungnh.simple.weather.data.model.Location;
import com.chungnh.simple.weather.data.model.Weather;

import java.util.List;

public interface MainView extends View {

    void showWeather(Weather weather);

    void showTodayWeather();

    void showWeekWeather();

    void showSearchSuggestion(List<Location> locations);
}
