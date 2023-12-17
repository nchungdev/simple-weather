package com.chungnh.simple.weather.di;

import com.chungnh.simple.weather.data.local.ForecastDbRepository;
import com.chungnh.simple.weather.data.local.LocationDbRepository;
import com.chungnh.simple.weather.data.remote.ForecastRepository;
import com.chungnh.simple.weather.data.remote.LocationRepository;
import com.chungnh.simple.weather.view.panel.MainPane;
import com.chungnh.simple.weather.view.panel.WelcomePane;

public class Injector {
    public static void inject(MainPane pane) {
        LocationDbRepository locationDbRepository = AppComponent.provideLocationDbRepository();
        LocationRepository locationRepository = AppComponent.provideLocationRepository(locationDbRepository);
        ForecastDbRepository forecastDbRepository = AppComponent.provideWeatherDbRepository();
        ForecastRepository forecastRepository = AppComponent.provideWeatherRepository();
        pane.setPresenter(AppComponent.provideMainPresenter(locationRepository, locationDbRepository, forecastDbRepository, forecastRepository));
    }

    public static void inject(WelcomePane pane) {
        pane.setPresenter(AppComponent.provideWelcomePresenter());
    }
}
