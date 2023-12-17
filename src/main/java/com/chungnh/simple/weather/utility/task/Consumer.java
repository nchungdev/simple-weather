package com.chungnh.simple.weather.utility.task;

@FunctionalInterface
public interface Consumer<T> {
    void accept(T t);
}
