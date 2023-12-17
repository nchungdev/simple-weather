package com.chungnh.simple.weather.utility.task;

import java.util.concurrent.atomic.AtomicReference;

public abstract class DisposableObserver<T> implements Observer<T>, Disposable {
    final AtomicReference<Disposable> upstream = new AtomicReference<>();

    @Override
    public final void onSubscribe(Disposable d) {
        onStart();
    }

    /**
     * Called once the single upstream Disposable is set via onSubscribe.
     */
    protected void onStart() {
    }

    @Override
    public final boolean isDisposed() {
        return upstream.get().isDisposed();
    }

    @Override
    public final void dispose() {
        upstream.get().dispose();
    }
}
