package com.chungnh.simple.weather.presenter;

import com.chungnh.simple.weather.utility.task.CompositeDisposable;
import com.chungnh.simple.weather.utility.task.Observable;
import com.chungnh.simple.weather.utility.task.Observer;
import com.chungnh.simple.weather.view.itf.View;

public abstract class Presenter<V extends View> {
    protected V view;

    protected boolean isReceived;
    private final CompositeDisposable disposable = new CompositeDisposable();

    public void attach(V view) {
        this.view = view;
    }

    public void opened() {
        System.out.println(getClass().getName() + " open");
    }

    public void closing() {
    }

    public void closed() {
        System.out.println(getClass().getName() + " close");
    }

    public void start() {
        System.out.println(getClass().getName() + " start");
        if (!isReceived) {
            getData();
        }
    }

    public void stop() {
        System.out.println(getClass().getName() + " stop");
        disposable.clear();
    }

    protected void getData() {

    }

    protected <T> void subscribe(Observable<T> observable, Observer<T> subscriber) {
        disposable.add(observable.subscribeWith(subscriber));
    }
}
