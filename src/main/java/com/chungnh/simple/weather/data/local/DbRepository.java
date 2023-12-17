package com.chungnh.simple.weather.data.local;

import java.util.List;

public interface DbRepository<T> {

    boolean insert(T item);

    List<T> getAll();
}
