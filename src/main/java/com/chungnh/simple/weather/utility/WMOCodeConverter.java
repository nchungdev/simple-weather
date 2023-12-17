package com.chungnh.simple.weather.utility;

import com.chungnh.simple.weather.data.model.WMO;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class WMOCodeConverter {
    private final HashMap<String, WMO> wmoHashMap = new HashMap<>();

    private static class Loader {
        static final WMOCodeConverter wmoCodeConverter = new WMOCodeConverter();
    }

    public static WMOCodeConverter getInstance() {
        return Loader.wmoCodeConverter;
    }

    private WMOCodeConverter() {
        String json = readFileFromResourceAsString();
        JSONParser parser = new JSONParser();
        try {
            JSONObject all = (JSONObject) parser.parse(json);
            for (Object entry : all.entrySet()) {
                if (entry instanceof Map.Entry<?, ?>) {
                    wmoHashMap.put((String) ((Map.Entry<?, ?>) entry).getKey(), getWmo((Map.Entry<?, ?>) entry));
                }
            }
        } catch (ParseException e) {

        }
    }

    private static WMO getWmo(Map.Entry<?, ?> entry) {
        JSONObject o = (JSONObject) entry.getValue();
        WMO wmo = new WMO();
        JSONObject day = (JSONObject) o.get("day");
        JSONObject night = (JSONObject) o.get("night");
        wmo.setDay(new WMO.Info((String) day.get("description"), (String) day.get("image"), (String) day.get("image_large")));
        wmo.setNight(new WMO.Info((String) night.get("description"), (String) night.get("image"), (String) day.get("image_large")));
        return wmo;
    }

    public WMO decode(long wmoCode) {
        return wmoHashMap.get(String.valueOf(wmoCode));
    }

    private String readFileFromResourceAsString() {
        // The class loader that loaded the class
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("raw/wmo_code.json")) {
            // the stream holding the file content
            return new String(Objects.requireNonNull(inputStream).readAllBytes(), StandardCharsets.UTF_8);
        } catch (Exception e) {
            return null;
        }
    }
}