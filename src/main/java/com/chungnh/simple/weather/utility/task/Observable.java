package com.chungnh.simple.weather.utility.task;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.Function;

public class Observable<T> implements Disposable, Observer<T> {
    private final List<Observer<T>> observers = new ArrayList<>();

    private final SimpleSwingWorker<T> swingWorker;

    public Observable(Callable<T> callable) {
        swingWorker = new SimpleSwingWorker<>(callable, this, Scheduler.MAIN);
    }

    public static <T> Observable<T> fromCallable(Callable<T> callable) {
        return new Observable<>(callable);
    }

    public void dispose() {
        swingWorker.dispose();
    }

    public boolean isDisposed() {
        return swingWorker.isDisposed();
    }

    public Observable<T> subscribeWith(Observer<T> observer) {
        observers.add(observer);
        swingWorker.execute();
        return this;
    }

    public void subscribe(Observer<T> subscriber) {
        observers.add(subscriber);
        swingWorker.execute();
    }

    public <U> Observable<U> map(Function<T, U> mapper) {
        Observable<U> mappedObservable = new Observable<>(() -> null);
        subscribeWith(new Observer<>() {
            @Override
            public void onSubscribe(Disposable disposable) {
                // No-op
            }

            @Override
            public void onNext(T value) {
                U mappedValue = mapper.apply(value);
                mappedObservable.observers.forEach(observer -> observer.onNext(mappedValue));
            }

            @Override
            public void onError(Throwable e) {
                mappedObservable.observers.forEach(observer -> observer.onError(e));
            }

            @Override
            public void onComplete() {
                mappedObservable.observers.forEach(Observer::onComplete);
            }
        });

        return mappedObservable;
    }

    public <U> Observable<U> flatMap(Function<T, Observable<U>> mapper) {
        Observable<U> flattenedObservable = new Observable<>(() -> null);
        subscribeWith(new Observer<>() {
            @Override
            public void onSubscribe(Disposable disposable) {
                // No-op
            }

            @Override
            public void onNext(T value) {
                try {
                    Observable<U> mappedObservable = mapper.apply(value);
                    mappedObservable.subscribeWith(new Observer<>() {
                        @Override
                        public void onSubscribe(Disposable disposable) {
                            // No-op
                        }

                        @Override
                        public void onNext(U value) {
                            flattenedObservable.observers.forEach(observer -> observer.onNext(value));
                        }

                        @Override
                        public void onError(Throwable e) {
                            flattenedObservable.observers.forEach(observer -> observer.onError(e));
                        }

                        @Override
                        public void onComplete() {
                            // No-op
                        }
                    });
                } catch (Exception e) {
                    flattenedObservable.observers.forEach(observer -> observer.onError(e));
                }
            }

            @Override
            public void onError(Throwable e) {
                flattenedObservable.observers.forEach(observer -> observer.onError(e));
            }

            @Override
            public void onComplete() {
                flattenedObservable.observers.forEach(Observer::onComplete);
            }
        });
        return flattenedObservable;
    }

    public Observable<T> doOnNext(Consumer<T> consumer) {
        observers.add(new SimpleSubscriber<>() {
            @Override
            public void onNext(T t) {
                consumer.accept(t);
            }
        });
        return this;
    }

    @Override
    public void onSubscribe(Disposable d) {
        observers.forEach(observer -> observer.onSubscribe(d));
    }

    @Override
    public void onNext(T t) {
        observers.forEach(observer -> observer.onNext(t));
    }

    @Override
    public void onError(Throwable e) {
        observers.forEach(observer -> observer.onError(e));
    }

    @Override
    public void onComplete() {
        observers.forEach(Observer::onComplete);
    }
}
