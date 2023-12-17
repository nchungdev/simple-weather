package com.chungnh.simple.weather.data.local;

import com.chungnh.simple.weather.data.mapper.ForecastMapper;
import com.chungnh.simple.weather.data.model.Forecast;
import com.chungnh.simple.weather.utility.FormatUtil;
import com.chungnh.simple.weather.utility.MappingUtil;
import org.json.simple.JSONObject;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ForecastDbRepository implements DbRepository<Forecast> {
    private final ForecastMapper forecastMapper = new ForecastMapper();

    @Override
    public boolean insert(Forecast item) {
        String json = forecastMapper.toJSON(item);
        String columns = FormatUtil.join(",",
                DbDefines.Weather.LATITUDE,
                DbDefines.Weather.LONGITUDE,
                DbDefines.Weather.TIMESTAMP,
                DbDefines.Weather.JSON);
        String values = FormatUtil.join(",",
                item.getLatitude(),
                item.getLongitude(),
                System.currentTimeMillis(),
                "'" + json + "'");
        try {
            return DatabaseHelper.getInstance().update("INSERT INTO %s(%s) VALUES (%s)".formatted(DbDefines.Weather.name(), columns, values)) > 0;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public List<Forecast> getAll() {
        try (ResultSet resultSet = DatabaseHelper.getInstance().query("SELECT json FROM %s".formatted(DbDefines.Weather.name()))) {
            ArrayList<Forecast> forecasts = new ArrayList<>();
            while (resultSet.next()) {
                JSONObject object = MappingUtil.toJSONObject(resultSet.getString(DbDefines.Weather.JSON));
                if (object != null) {
                    forecasts.add(forecastMapper.fromJSON(object));
                }
            }
            return forecasts;
        } catch (SQLException e) {
            return Collections.emptyList();
        }
    }
}
