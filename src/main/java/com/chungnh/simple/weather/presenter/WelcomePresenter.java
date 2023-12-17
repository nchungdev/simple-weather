package com.chungnh.simple.weather.presenter;


import com.chungnh.simple.weather.view.itf.WelcomeView;

import java.util.Timer;
import java.util.TimerTask;

public class WelcomePresenter extends Presenter<WelcomeView> {
    private int progress;

    @Override
    public void attach(WelcomeView view) {
        super.attach(view);
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                view.setProgress(progress += 10);
                if (progress >= 100) {
                    timer.cancel(); // Stop the timer
                    splashComplete();
                }
            }
        };
        timer.schedule(task, 0, 100);
    }

    public void splashComplete() {
        view.openHome();
    }
}
