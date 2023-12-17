package com.chungnh.simple.weather.view.base;

import com.chungnh.simple.weather.presenter.Presenter;
import com.chungnh.simple.weather.view.itf.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public abstract class BasePanel<P extends Presenter<?>> extends JPanel implements View {

    protected P presenter;

    private Lifecycle listener;
    private boolean isVisible;

    public void setPresenter(P presenter) {
        this.presenter = presenter;
        listener = new Lifecycle(presenter);
        addHierarchyListener(e -> {
            Window window = SwingUtilities.getWindowAncestor(getComp());
            if (window == null) {
                return;
            }
            boolean amIVisible = amIVisible();
            if (amIVisible == isVisible) {
                return;
            }
            if (amIVisible) {
                presenter.opened();
                presenter.start();
                window.addWindowListener(listener);
            } else {
                window.removeWindowListener(listener);
                presenter.stop();
                presenter.closed();
            }
            isVisible = amIVisible;
        });
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                super.componentShown(e);
                if (e.getComponent() == BasePanel.this && !isVisible) {
                    isVisible = true;
                    presenter.start();
                }
            }

            @Override
            public void componentHidden(ComponentEvent e) {
                if (e.getComponent() == BasePanel.this && isVisible) {
                    presenter.stop();
                    isVisible = false;
                }
                super.componentHidden(e);
            }
        });
    }

    public BasePanel() {
        setName(getClass().getName());
    }

    private boolean amIVisible() {
        Container c = getParent();
        while (c != null) {
            if (!c.isVisible()) {
                return false;
            } else {
                c = c.getParent();
            }
        }
        return isVisible();
    }

    @Override
    public Component getComp() {
        return this;
    }

}
