package com.chungnh.simple.weather.utility.task;

import java.util.concurrent.CopyOnWriteArrayList;

public class CompositeDisposable {
    private final CopyOnWriteArrayList<Disposable> disposables = new CopyOnWriteArrayList<>();

    public void add(Disposable disposable) {
        disposables.add(disposable);
    }

    public void clear() {
        for (Disposable disposable : disposables) {
            if (!disposable.isDisposed()) {
                disposable.dispose();
            }
        }
    }
}
