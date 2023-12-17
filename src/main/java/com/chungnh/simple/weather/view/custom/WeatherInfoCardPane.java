/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chungnh.simple.weather.view.custom;

import com.chungnh.simple.weather.utility.image.ImageLoader;

/**
 * @author chungnh
 */
public class WeatherInfoCardPane extends javax.swing.JPanel {

    /**
     * Creates new form WeatherInfoCardPane
     */
    public WeatherInfoCardPane() {
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

        txtPropName = new javax.swing.JLabel();
        txtPropValue = new javax.swing.JLabel();
        icInfo = new javax.swing.JLabel();

        setBackground(new java.awt.Color(233, 236, 239));

        txtPropName.setText("Humility");

        txtPropValue.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        txtPropValue.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txtPropValue.setText("30");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, 0)
                                .addComponent(icInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtPropValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtPropName, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE))
                                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                        .addComponent(icInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtPropName, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, 0)
                                .addComponent(txtPropValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[]{icInfo, txtPropName});

    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel icInfo;
    private javax.swing.JLabel txtPropName;
    private javax.swing.JLabel txtPropValue;
    // End of variables declaration//GEN-END:variables


    public void setTitle(String title) {
        txtPropName.setText(title);
    }

    public void setValue(String value) {
        txtPropValue.setText(value);
    }

    public void setIcon(String icWindSpeed) {
        ImageLoader.load(icWindSpeed, null, icInfo);
    }
}
