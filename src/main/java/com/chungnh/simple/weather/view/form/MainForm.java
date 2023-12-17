package com.chungnh.simple.weather.view.form;

import com.chungnh.simple.weather.view.panel.WelcomePane;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;

public class MainForm extends JFrame {
    private static Component lastFocusedComponent;

    /**
     * Creates new form MainScreen
     */
    public MainForm() {
        addInputMethodListener(new InputMethodListener() {
            @Override
            public void inputMethodTextChanged(InputMethodEvent event) {
                System.out.println("TextChanged");
            }

            @Override
            public void caretPositionChanged(InputMethodEvent event) {

            }
        });
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(600, 800));
        setContentPane(new WelcomePane());
        setResizable(false);
        pack();
        setVisible(true);
    }
}
