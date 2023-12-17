package com.chungnh.simple.weather.view.itf;

import com.chungnh.simple.weather.data.model.ListHourly;

public interface HourlyWeatherView extends View {
    void showData(ListHourly listHourly);
}
