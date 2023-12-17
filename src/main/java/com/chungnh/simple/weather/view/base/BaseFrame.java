package com.chungnh.simple.weather.view.base;

import com.chungnh.simple.weather.presenter.Presenter;
import com.chungnh.simple.weather.view.itf.View;

import javax.swing.*;
import java.awt.*;

public abstract class BaseFrame<P extends Presenter<?>> extends JFrame implements View {

    protected P presenter;
    private JPanel currentPane;

    public BaseFrame() {
    }

    public void setPresenter(P presenter) {
        this.presenter = presenter;
        addWindowListener(new Lifecycle(presenter));
    }

    @Override
    public Component getComp() {
        return this;
    }

}
