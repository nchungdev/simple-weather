package com.chungnh.simple.weather.di;

import com.chungnh.simple.weather.data.local.LocationDbRepository;
import com.chungnh.simple.weather.data.local.ForecastDbRepository;
import com.chungnh.simple.weather.data.remote.LocationRepository;
import com.chungnh.simple.weather.data.remote.ForecastRepository;
import com.chungnh.simple.weather.presenter.MainPresenter;
import com.chungnh.simple.weather.presenter.WelcomePresenter;

public class AppComponent {
    static WelcomePresenter provideWelcomePresenter() {
        return new WelcomePresenter();
    }

    static MainPresenter provideMainPresenter(LocationRepository locationRepository,
                                              LocationDbRepository locationDbRepository,
                                              ForecastDbRepository forecastDbRepository,
                                              ForecastRepository forecastRepository) {
        return new MainPresenter(locationRepository, locationDbRepository, forecastRepository, forecastDbRepository);
    }

    static LocationRepository provideLocationRepository(LocationDbRepository locationDbRepository) {
        return new LocationRepository(locationDbRepository);
    }

    static LocationDbRepository provideLocationDbRepository() {
        return new LocationDbRepository();
    }

    static ForecastRepository provideWeatherRepository() {
        return new ForecastRepository();
    }

    static ForecastDbRepository provideWeatherDbRepository() {
        return new ForecastDbRepository();
    }
}
