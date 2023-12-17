package com.chungnh.simple.weather.view.base;

import com.chungnh.simple.weather.presenter.Presenter;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Lifecycle implements WindowListener {

    private final Presenter<?> presenter;

    public Lifecycle(Presenter<?> presenter) {
        this.presenter = presenter;
    }

    @Override
    public void windowOpened(WindowEvent e) {
        presenter.opened();
    }

    @Override
    public void windowClosing(WindowEvent e) {
        presenter.closing();
    }

    @Override
    public void windowClosed(WindowEvent e) {
        presenter.closed();
    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {
        presenter.start();
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        presenter.stop();
    }
}
