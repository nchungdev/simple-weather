package com.chungnh.simple.weather.view.itf;

import com.chungnh.simple.weather.data.model.ListDaily;

public interface DailyWeatherView extends View {
    void showData(ListDaily listDaily);
}
