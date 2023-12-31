package com.chungnh.simple.weather.utility.task;

public interface Observer<T> {

    void onSubscribe(Disposable d);

    void onNext(T t);

    void onError(Throwable e);

    void onComplete();
}
