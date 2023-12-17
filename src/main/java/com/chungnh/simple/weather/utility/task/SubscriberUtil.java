package com.chungnh.simple.weather.utility.task;

import javax.swing.*;

public class SubscriberUtil {

    public static void subscribe(Scheduler scheduler, Runnable runnable) {
        switch (scheduler) {
            case MAIN -> SwingUtilities.invokeLater(runnable);
            case IO -> new Thread(runnable).start();
            case COMPUTATION -> new Thread(runnable).start();
        }
    }
}
