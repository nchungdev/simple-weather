/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chungnh.simple.weather.view.panel;

import com.chungnh.simple.weather.data.model.Forecast;
import com.chungnh.simple.weather.data.model.WMO;
import com.chungnh.simple.weather.data.model.Weather;
import com.chungnh.simple.weather.utility.FormatUtil;
import com.chungnh.simple.weather.utility.WMOCodeConverter;
import com.chungnh.simple.weather.utility.image.ImageLoader;

import javax.swing.*;
import java.awt.*;

/**
 * @author chungnh
 */
public class BigWeatherPane extends JPanel {

    /**
     * Creates new form BigWeatherPane
     */
    public BigWeatherPane() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtLocation = new javax.swing.JLabel();
        txtStatus = new javax.swing.JLabel();
        txtTemparature = new javax.swing.JLabel();
        icWeather = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        txtLocation.setFont(new java.awt.Font("Lucida Grande", 0, 30)); // NOI18N
        txtLocation.setText("Ho Chi Minh");

        txtStatus.setText("Mostly Cloudy");

        txtTemparature.setFont(new java.awt.Font("Lucida Grande", 0, 48)); // NOI18N
        txtTemparature.setText("30*C");

        icWeather.setIconTextGap(0);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtStatus)
                    .addComponent(txtLocation)
                    .addComponent(txtTemparature))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addComponent(icWeather, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(txtLocation)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtStatus)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addComponent(txtTemparature)
                .addGap(20, 20, 20))
            .addComponent(icWeather, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel icWeather;
    private javax.swing.JLabel txtLocation;
    private javax.swing.JLabel txtStatus;
    private javax.swing.JLabel txtTemparature;
    // End of variables declaration//GEN-END:variables

    public void setData(Weather weather) {
        Forecast.Current current = weather.getForecast().getCurrent();
        WMO wmo = WMOCodeConverter.getInstance().decode(current.getWeatherCode());
        String imageLarge = wmo.get(current.isDay()).getImageLarge();
        ImageLoader.load(imageLarge, new Dimension(200, 200), icWeather);
        txtStatus.setText(wmo.get(current.isDay()).getDescription());
        txtTemparature.setText(FormatUtil.temperature(current.getTemperature()));
        txtLocation.setText(weather.getLocation().getName());
    }
}
