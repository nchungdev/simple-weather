package com.chungnh.simple.weather.data.local;

import com.chungnh.simple.weather.data.mapper.LocationMapper;
import com.chungnh.simple.weather.data.model.Location;
import com.chungnh.simple.weather.utility.FormatUtil;
import com.chungnh.simple.weather.utility.MappingUtil;
import org.json.simple.JSONObject;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LocationDbRepository implements DbRepository<Location> {
    private final LocationMapper locationMapper = new LocationMapper();

    @Override
    public boolean insert(Location item) {
        String json = locationMapper.toJSON(item);
        String columns = FormatUtil.join(",",
                DbDefines.Location._ID,
                DbDefines.Location.NAME,
                DbDefines.Location.LATITUDE,
                DbDefines.Location.LONGITUDE,
                DbDefines.Location.TIMESTAMP,
                DbDefines.Location.JSON);
        String values = FormatUtil.join(",",
                item.getId(),
                "'" + item.getName() + "'",
                item.getLatitude(),
                item.getLongitude(),
                System.currentTimeMillis(),
                "'" + json + "'");
        try {
            return DatabaseHelper.getInstance().update("INSERT INTO " + DbDefines.Location.name()
                    + "(" + columns + ") "
                    + "VALUES (" + values + ")") > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Location> getAll() {
        try (ResultSet resultSet = DatabaseHelper.getInstance().query("SELECT * FROM " + DbDefines.Location.name())) {
            ArrayList<Location> locations = new ArrayList<>();
            while (resultSet.next()) {
                JSONObject object = MappingUtil.toJSONObject(resultSet.getString(DbDefines.Location.JSON));
                if (object != null) {
                    locations.add(locationMapper.fromJSON(object));
                }
            }
            return locations;
        } catch (SQLException e) {
            return Collections.emptyList();
        }
    }

    public Location getLastLocation() {
        try (ResultSet resultSet = DatabaseHelper.getInstance().query("SELECT json FROM " + DbDefines.Location.name() + " ORDER BY timestamp DESC LIMIT 1")) {
            while (resultSet.next()) {
                JSONObject object = MappingUtil.toJSONObject(resultSet.getString(DbDefines.Weather.JSON));
                if (object != null) {
                    return locationMapper.fromJSON(object);
                }
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Location> search(String name) {
        ArrayList<Location> locations = new ArrayList<>();
        try (ResultSet resultSet = DatabaseHelper.getInstance().query("SELECT json FROM %s WHERE name LIKE %s".formatted(DbDefines.Location.name(), name))) {
            while (resultSet.next()) {
                JSONObject object = MappingUtil.toJSONObject(resultSet.getString(DbDefines.Weather.JSON));
                if (object != null) {
                    locations.add(locationMapper.fromJSON(object));
                }
            }
            return locations;
        } catch (SQLException e) {
            return locations;
        }
    }
}
