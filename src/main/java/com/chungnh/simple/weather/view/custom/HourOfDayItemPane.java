/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.chungnh.simple.weather.view.custom;


import com.chungnh.simple.weather.data.model.ListHourly;
import com.chungnh.simple.weather.data.model.WMO;
import com.chungnh.simple.weather.utility.FormatUtil;
import com.chungnh.simple.weather.utility.DateTimeUtil;
import com.chungnh.simple.weather.utility.WMOCodeConverter;
import com.chungnh.simple.weather.utility.image.ImageLoader;

import javax.swing.*;
import java.awt.*;

/**
 * @author chungnh
 */
public class HourOfDayItemPane extends JPanel {

    /**
     * Creates new form HourlyWeatherItemPanel
     */
    public HourOfDayItemPane(ListHourly.Item item) {
        initComponents();
        setOpaque(false);
        WMO wmo = WMOCodeConverter.getInstance().decode(item.getWeatherCode());
        ImageLoader.loadSmIconWithShadow(wmo.get(item.isDay()).getImageUrl(), icWeather);
        ((ImageView) icWeather).setShadowPosition(1, 4);
        icWeather.setPreferredSize(new Dimension(icWeather.getWidth(), 48));
        txtDay.setText(DateTimeUtil.hourOfDay(item.getTime()));
        txtTemparature.setText(FormatUtil.temperature(item.getTemperature()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtDay = new javax.swing.JLabel();
        icWeather = new ImageView();
        txtTemparature = new javax.swing.JLabel();

        setOpaque(false);

        txtDay.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        txtDay.setForeground(new java.awt.Color(147, 153, 162));
        txtDay.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtDay.setText("13");
        txtDay.setPreferredSize(new java.awt.Dimension(100, 17));

        icWeather.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        icWeather.setIconTextGap(0);
        icWeather.setMaximumSize(new java.awt.Dimension(24, 24));
        icWeather.setMinimumSize(new java.awt.Dimension(24, 24));
        icWeather.setPreferredSize(new java.awt.Dimension(48, 48));

        txtTemparature.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        txtTemparature.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTemparature.setText("28℃");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                .addComponent(icWeather, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(txtDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(txtTemparature, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(txtDay, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(icWeather, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(txtTemparature, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel icWeather;
    private javax.swing.JLabel txtDay;
    private javax.swing.JLabel txtTemparature;
    // End of variables declaration//GEN-END:variables
}