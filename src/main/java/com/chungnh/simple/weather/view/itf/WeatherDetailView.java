package com.chungnh.simple.weather.view.itf;

import com.chungnh.simple.weather.data.model.Weather;

public interface WeatherDetailView extends View {
    void showData(Weather weather);

    void showError(Throwable e);

    void showLoading();

    void hideLoading();
}
