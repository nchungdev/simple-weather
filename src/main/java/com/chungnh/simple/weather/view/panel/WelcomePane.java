/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chungnh.simple.weather.view.panel;

import com.chungnh.simple.weather.di.Injector;
import com.chungnh.simple.weather.presenter.WelcomePresenter;
import com.chungnh.simple.weather.view.base.BasePanel;
import com.chungnh.simple.weather.view.form.MainForm;
import com.chungnh.simple.weather.view.itf.WelcomeView;

import javax.swing.*;
import java.awt.*;

/**
 * @author chungnh
 */
public class WelcomePane extends BasePanel<WelcomePresenter> implements WelcomeView {

    /**
     * Creates new form WelcomePane
     */
    public WelcomePane() {
        initComponents();
        Injector.inject(this);
        pbLoading.setMaximum(100);
        presenter.attach(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pbLoading = new javax.swing.JProgressBar();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setOpaque(false);

        pbLoading.setPreferredSize(new java.awt.Dimension(146, 36));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/drawable/logo.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel1.setText("Simple Weather");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(pbLoading, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(219, 219, 219)
                .addComponent(jLabel2)
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addGap(57, 57, 57)
                .addComponent(pbLoading, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(134, Short.MAX_VALUE))
        );

        add(jPanel1);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar pbLoading;
    // End of variables declaration//GEN-END:variables

    @Override
    public void openHome() {
        Component root = SwingUtilities.getRoot(this);
        if (root instanceof MainForm) {
            ((MainForm) root).setContentPane(new MainPane());
            ((MainForm) root).pack();
            ((MainForm) root).setLocationRelativeTo(null);
        }
    }

    @Override
    public void setProgress(int progress) {
        pbLoading.setValue(progress);
    }
}
