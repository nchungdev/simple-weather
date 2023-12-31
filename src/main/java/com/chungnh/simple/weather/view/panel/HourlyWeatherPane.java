/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.chungnh.simple.weather.view.panel;

import com.chungnh.simple.weather.data.model.ListHourly;
import com.chungnh.simple.weather.view.custom.HourOfDayItemPane;
import com.chungnh.simple.weather.view.custom.RoundedPanel;
import com.chungnh.simple.weather.view.custom.TransparentScrollPane;

import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * @author chungnh
 */
public class HourlyWeatherPane extends RoundedPanel {

    /**
     * Creates new form TodayWeatherPane
     */
    public HourlyWeatherPane() {
        initComponents();
        jLabel1.setBorder(new EmptyBorder(0, 20, 0, 0));
        pnlHourly.setBorder(new EmptyBorder(0, 0, 10, 0));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        scrollPane = new TransparentScrollPane();
        pnlHourly = new javax.swing.JPanel();

        setBackground(new java.awt.Color(233, 236, 239));

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel1.setText("Today's Forecast");

        scrollPane.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        scrollPane.setViewportBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        scrollPane.setOpaque(false);
        scrollPane.setRowHeaderView(null);

        pnlHourly.setOpaque(false);

        javax.swing.GroupLayout pnlHourlyLayout = new javax.swing.GroupLayout(pnlHourly);
        pnlHourly.setLayout(pnlHourlyLayout);
        pnlHourlyLayout.setHorizontalGroup(
            pnlHourlyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 267, Short.MAX_VALUE)
        );
        pnlHourlyLayout.setVerticalGroup(
            pnlHourlyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        scrollPane.setViewportView(pnlHourly);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(scrollPane))
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(scrollPane)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel pnlHourly;
    private javax.swing.JScrollPane scrollPane;
    // End of variables declaration//GEN-END:variables

    public void setData(ListHourly listHourly) {
        pnlHourly.removeAll();
        pnlHourly.setLayout(new GridLayout(1, listHourly.size(), 10, 0));
        for (ListHourly.Item item : listHourly) {
            pnlHourly.add(new HourOfDayItemPane(item));
        }
    }
}
