package com.chungnh.simple.weather.utility.task;


import javax.swing.*;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;

class SimpleSwingWorker<T> extends SwingWorker<T, Void> implements Disposable {
    private final Callable<T> callable;
    private final Observer<T> observer;
    private final Scheduler scheduler;

    SimpleSwingWorker(Callable<T> callable, Observer<T> observer, Scheduler scheduler) {
        this.callable = callable;
        this.observer = observer;
        this.scheduler = scheduler;
    }

    @Override
    protected T doInBackground() throws Exception {
        observer.onSubscribe(this);
        return callable.call();
    }

    @Override
    protected void done() {
        SubscriberUtil.subscribe(scheduler, () -> {
            try {
                // Get the result of the background task
                T result = get();
                if (result == null) {
                    observer.onError(new Exception("No result"));
                    return;
                }
                // Perform any UI updates or other actions based on the result
                observer.onNext(result);
            } catch (Exception e) {
                if (e instanceof CancellationException) {
                    return;
                }
                e.printStackTrace();
                observer.onError(new Exception("No result"));
            }
        });
    }

    @Override
    public boolean isDisposed() {
        return isDone() || isCancelled();
    }

    @Override
    public void dispose() {
        cancel(true);
    }

    public interface Callback<T> {
        void invoke(T t);
    }
}
    
