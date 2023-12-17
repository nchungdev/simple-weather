/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chungnh.simple.weather.presenter;

import com.chungnh.simple.weather.data.local.ForecastDbRepository;
import com.chungnh.simple.weather.data.local.LocationDbRepository;
import com.chungnh.simple.weather.data.model.Location;
import com.chungnh.simple.weather.data.model.Weather;
import com.chungnh.simple.weather.data.remote.ForecastRepository;
import com.chungnh.simple.weather.data.remote.LocationRepository;
import com.chungnh.simple.weather.utility.task.Debouncer;
import com.chungnh.simple.weather.utility.task.Disposable;
import com.chungnh.simple.weather.utility.task.SimpleSubscriber;
import com.chungnh.simple.weather.view.itf.MainView;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author chungnh
 */
public class MainPresenter extends Presenter<MainView> {

    private final LocationRepository locationRepository;
    private final LocationDbRepository locationDbRepository;
    private final ForecastRepository weatherRepository;
    private Disposable disposable;
    private final Debouncer<String> debouncer = new Debouncer<>(new Debouncer.Callback<>() {
        @Override
        public void call(String keyword) {
            if (disposable != null && !disposable.isDisposed()) {
                disposable.dispose();
            }
            disposable = locationRepository.search(keyword).subscribeWith(new SimpleSubscriber<>() {
                @Override
                public void onNext(List<Location> locations) {
                    view.showSearchSuggestion(locations);
                }
            });
        }
    }, 300);


    private long lastTimeUpdate;

    public MainPresenter(LocationRepository locationRepository, LocationDbRepository locationDbRepository, ForecastRepository forecastRepository, ForecastDbRepository forecastDbRepository) {
        this.locationRepository = locationRepository;
        this.locationDbRepository = locationDbRepository;
        this.weatherRepository = forecastRepository;
    }

    @Override
    public void start() {
        if (System.currentTimeMillis() - lastTimeUpdate > TimeUnit.MINUTES.toMillis(15)) {
            isReceived = false;
        }
        super.start();
    }

    @Override
    public void stop() {
        if (disposable != null) disposable.dispose();
        super.stop();
    }

    public void showTodayWeather() {
        view.showTodayWeather();
    }

    public void showWeekWeather() {
        view.showWeekWeather();
    }

    public void onKeywordChange(String keyword) {
        debouncer.publish(keyword);
    }

    @Override
    protected void getData() {
        subscribe(locationRepository.getRecentLocation().flatMap(weatherRepository::getWeather), new SimpleSubscriber<>() {
            @Override
            public void onNext(Weather weather) {
                super.onNext(weather);
                isReceived = true;
                lastTimeUpdate = System.currentTimeMillis();
                view.showWeather(weather);
            }
        });
    }

    public void onLocationSelected(Location location) {
        subscribe(weatherRepository.getWeather(location).doOnNext(locationWeather -> locationDbRepository.insert(location)), new SimpleSubscriber<>() {
            @Override
            public void onNext(Weather weather) {
                view.showWeather(weather);
            }
        });
    }
}
