/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.chungnh.simple.weather.view.panel;

import com.chungnh.simple.weather.data.model.ListHourly;
import com.chungnh.simple.weather.data.model.Location;
import com.chungnh.simple.weather.data.model.Weather;
import com.chungnh.simple.weather.di.Injector;
import com.chungnh.simple.weather.presenter.MainPresenter;
import com.chungnh.simple.weather.utility.DateTimeUtil;
import com.chungnh.simple.weather.utility.MappingUtil;
import com.chungnh.simple.weather.view.base.BasePanel;
import com.chungnh.simple.weather.view.custom.HintTextField;
import com.chungnh.simple.weather.view.custom.RoundedPanel;
import com.chungnh.simple.weather.view.itf.MainView;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.util.List;

/**
 * @author chungnh
 */
public class MainPane extends BasePanel<MainPresenter> implements MainView {

    private final JPopupMenu popup;

    private final DailyWeatherPane dailyWeatherPane;
    private final HourlyWeatherPane hourlyWeatherPane;
    private final BigWeatherPane bigWeatherPane;
    private final OtherWeatherInfoPane otherWeatherInfoPane;

    /**
     * Creates new form HomePane
     */
    public MainPane() {
        Injector.inject(this);
        initComponents();
        presenter.attach(this);
        // setup for search
        pnlSearchBox.setBorder(new EmptyBorder(0, 20, 0, 20));
        pnlSearchBoxContainer.setBorder(new EmptyBorder(0, 20, 0, 12));
        popup = new JPopupMenu();
        tfSearch.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                onKeywordChange(tfSearch.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });

        // setup for right sidebar
        dailyWeatherPane = new DailyWeatherPane();
        pnlWeek.setBackground(Color.WHITE);
        pnlWeek.setBorder(new EmptyBorder(80, 0, 20, 20));
        pnlWeek.add(dailyWeatherPane);

        // setup for main content
        bigWeatherPane = new BigWeatherPane();
        hourlyWeatherPane = new HourlyWeatherPane();
        otherWeatherInfoPane = new OtherWeatherInfoPane();
        pnlMain.setBorder(new EmptyBorder(0, 20, 0, 20));

        pnTop.setBorder(new EmptyBorder(0, 10, 20, 0));
        pnTop.add(bigWeatherPane);
        pnlCenter.add(hourlyWeatherPane);
        pnlCenter.setBorder(new EmptyBorder(10, 0, 20, 0));
        pnlBottom.add(otherWeatherInfoPane);
        pnlBottom.setBackground(Color.WHITE);
        pnlBottom.setBorder(new EmptyBorder(0, 0, 20, 0));
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
        pnlMain = new javax.swing.JPanel();
        pnTop = new javax.swing.JPanel();
        pnlCenter = new javax.swing.JPanel();
        pnlBottom = new javax.swing.JPanel();
        pnlSearchBox = new javax.swing.JPanel();
        pnlSearchBoxContainer = new RoundedPanel();
        tfSearch = new HintTextField();
        jLabel1 = new javax.swing.JLabel();
        pnlWeek = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setOpaque(false);

        pnlMain.setBackground(new java.awt.Color(255, 255, 255));
        pnlMain.setOpaque(false);

        pnTop.setBackground(new java.awt.Color(255, 255, 255));
        pnTop.setOpaque(false);
        pnTop.setLayout(new java.awt.GridLayout(1, 0));

        pnlCenter.setBackground(new java.awt.Color(255, 255, 255));
        pnlCenter.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        pnlCenter.setOpaque(false);
        pnlCenter.setLayout(new java.awt.GridLayout(1, 0));

        pnlBottom.setBackground(new java.awt.Color(255, 255, 255));
        pnlBottom.setOpaque(false);
        pnlBottom.setLayout(new java.awt.GridLayout(1, 0));

        javax.swing.GroupLayout pnlMainLayout = new javax.swing.GroupLayout(pnlMain);
        pnlMain.setLayout(pnlMainLayout);
        pnlMainLayout.setHorizontalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnTop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlCenter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlBottom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlMainLayout.setVerticalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addComponent(pnTop, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlCenter, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(pnlBottom, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnlMainLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {pnTop, pnlBottom, pnlCenter});

        pnlSearchBox.setOpaque(false);

        tfSearch.setBackground(new java.awt.Color(233, 236, 239));
        tfSearch.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        tfSearch.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        tfSearch.setText("Search for places");
        tfSearch.setBorder(null);
        tfSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfSearchActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/drawable/ic_search.png"))); // NOI18N

        javax.swing.GroupLayout pnlSearchBoxContainerLayout = new javax.swing.GroupLayout(pnlSearchBoxContainer);
        pnlSearchBoxContainer.setLayout(pnlSearchBoxContainerLayout);
        pnlSearchBoxContainerLayout.setHorizontalGroup(
            pnlSearchBoxContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSearchBoxContainerLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(tfSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 649, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addContainerGap())
        );
        pnlSearchBoxContainerLayout.setVerticalGroup(
            pnlSearchBoxContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSearchBoxContainerLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(pnlSearchBoxContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(0, 0, 0))
        );

        pnlSearchBoxContainerLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel1, tfSearch});

        javax.swing.GroupLayout pnlSearchBoxLayout = new javax.swing.GroupLayout(pnlSearchBox);
        pnlSearchBox.setLayout(pnlSearchBoxLayout);
        pnlSearchBoxLayout.setHorizontalGroup(
            pnlSearchBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlSearchBoxContainer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlSearchBoxLayout.setVerticalGroup(
            pnlSearchBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSearchBoxLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(pnlSearchBoxContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlSearchBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlMain, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(pnlSearchBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnlMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlWeek.setBackground(new java.awt.Color(255, 255, 255));
        pnlWeek.setOpaque(false);
        pnlWeek.setLayout(new java.awt.GridLayout(1, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(pnlWeek, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlWeek, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tfSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfSearchActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel pnTop;
    private javax.swing.JPanel pnlBottom;
    private javax.swing.JPanel pnlCenter;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JPanel pnlSearchBox;
    private javax.swing.JPanel pnlSearchBoxContainer;
    private javax.swing.JPanel pnlWeek;
    private javax.swing.JTextField tfSearch;
    // End of variables declaration//GEN-END:variables

    @Override
    public void showWeather(Weather weather) {
        ListHourly items = MappingUtil.toList(weather.getForecast().getHourly());
        List<ListHourly.Item> list = items.stream().filter(item -> DateTimeUtil.isSinceNow(item.getTime())).toList();
        items.clear();
        items.addAll(list);
        dailyWeatherPane.setData(MappingUtil.toList(weather.getForecast().getDaily()));
        hourlyWeatherPane.setData(items);
        bigWeatherPane.setData(weather);
        otherWeatherInfoPane.setData(weather);
    }

    @Override
    public void showTodayWeather() {
    }

    @Override
    public void showWeekWeather() {
    }

    @Override
    public void showSearchSuggestion(List<Location> locations) {
        popup.removeAll();
        for (Location location : locations) {
            JMenuItem item = new JMenuItem(location.getName());
            item.addActionListener(e -> presenter.onLocationSelected(location));
            popup.add(item);
        }
        popup.show(tfSearch, 3, tfSearch.getHeight());
    }

    public void onKeywordChange(String keyword) {
        presenter.onKeywordChange(keyword);
    }
}
