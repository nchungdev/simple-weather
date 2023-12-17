package com.chungnh.simple.weather.utility.task;


@FunctionalInterface
public interface ObservableSource<T> {
    void subscribe(Observer<? super T> observer);
}
