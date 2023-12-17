/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chungnh.simple.weather.data.local;

import java.sql.*;

/**
 * @author chungnh
 */
public class DatabaseHelper {
    //    private static final String SQL_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
//    private static final String DB_URL = "jdbc:sqlserver://DESKTOP-A9JVF1E\\SQLEXPRESS:1433;databaseName=MyWeather;user=sa;password=12";
    private static final String DB_URL = "jdbc:sqlite:weather";
    private Connection dbConnection;

    private static DatabaseHelper INSTANCE;

    public static DatabaseHelper getInstance() {
        if (INSTANCE == null)
            INSTANCE = new DatabaseHelper();
        return INSTANCE;
    }

    public DatabaseHelper() {
        createDbConnection();
        createTables();
    }

    public void createTables() {
        try (Statement statement = dbConnection.createStatement()) {
            createLocationTable(statement);
            createWeatherTable(statement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void createLocationTable(Statement statement) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS " + DbDefines.Location.name() +
                " (" + DbDefines.Location._ID + " LONG, "
                + DbDefines.Location.NAME + " TEXT, "
                + DbDefines.Location.LATITUDE + " DOUBLE,"
                + DbDefines.Location.LONGITUDE + " DOUBLE, "
                + DbDefines.Location.TIMESTAMP + " LONG, "
                + DbDefines.Location.JSON + " TEXT "
                + ")";
        statement.execute(sql);
    }

    private void createWeatherTable(Statement statement) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS " + DbDefines.Weather.name() +
                " (" + DbDefines.Weather._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + DbDefines.Weather.LATITUDE + " DOUBLE, "
                + DbDefines.Weather.LONGITUDE + " DOUBLE, "
                + DbDefines.Weather.TIMESTAMP + " LONG, "
                + DbDefines.Weather.JSON + " TEXT "
                + ")";
        try {
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createDbConnection() {
        try {
            dbConnection = DriverManager.getConnection(DB_URL);
            System.out.println("Connect successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            if (dbConnection != null && !dbConnection.isClosed()) {
                dbConnection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet query(String sql) throws SQLException {
        return dbConnection.createStatement().executeQuery(sql);
    }

    public int update(String sql) throws SQLException {
        return dbConnection.createStatement().executeUpdate(sql);
    }
}
