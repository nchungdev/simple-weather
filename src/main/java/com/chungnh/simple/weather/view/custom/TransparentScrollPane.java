package com.chungnh.simple.weather.view.custom;

import javax.swing.*;
import java.awt.*;

public class TransparentScrollPane extends JScrollPane {

    public TransparentScrollPane() {
        setOpaque(false);
    }

    @Override
    protected JViewport createViewport() {
        return new CustomViewport();
    }


    @Override
    public JScrollBar createHorizontalScrollBar() {
        return new ScrollBar(JScrollBar.HORIZONTAL);
    }

    private static class CustomViewport extends JViewport {
        public CustomViewport() {
            setOpaque(false);
        }
    }


    public static class ScrollBar extends JScrollBar {
        public ScrollBar(int orientation, int value, int extent, int min, int max) {
            super(orientation, value, extent, min, max);
        }

        public ScrollBar(int orientation) {
            super(orientation);
        }

        public ScrollBar() {
        }

        @Override
        public void paint(Graphics g) {
//            super.paint(g);
        }
    }

}
