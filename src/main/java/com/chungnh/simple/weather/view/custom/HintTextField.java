/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chungnh.simple.weather.view.custom;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * @author chungnh
 */
public class HintTextField extends JTextField {

    private String hint;
    private final Font gainFont = new Font("Tahoma", Font.PLAIN, 11);
    private final Font lostFont = new Font("Tahoma", Font.ITALIC, 11);

    public HintTextField() {
        setOpaque(false);
        setBorder(new EmptyBorder(0, 16, 0, 16));
    }
}
