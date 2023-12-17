package com.chungnh.simple.weather.view.form;

import com.chungnh.simple.weather.view.panel.WelcomePane;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    /**
     * Creates new form MainScreen
     */
    public MainFrame() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(600, 800));
        setContentPane(new WelcomePane());
        setResizable(false);
        setIconImage(new ImageIcon(getClass().getResource("/drawable/logo.png")).getImage());
        pack();
        setVisible(true);
    }
}
