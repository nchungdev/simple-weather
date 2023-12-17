package com.chungnh.simple.weather.utility;

public class FormatUtil {
    private static final String UNIT_C = "°";
    private static final String UNIT_SPEED = "km/h";
    private static final String UNIT_HUMIDITY = "%";
    private static final String UNIT_CLOUD_COVER = "%";
    private static final String UNIT_MM = "mm";

    public static String temperature(double temperature) {
        return "%s%s".formatted(temperature, UNIT_C);
    }

    public static String temperature(double max, double min) {
        return "%s/%s".formatted(Math.round(max), Math.round(min));
    }

    public static String formatWindySpeed(double speed) {
        return "%s%s".formatted(speed, UNIT_SPEED);
    }

    public static String formatHumidity(double humidity) {
        return "%s%s".formatted(humidity, UNIT_HUMIDITY);
    }

    public static String formatCloudCover(double cloudCover) {
        return "%s %s".formatted(cloudCover, UNIT_CLOUD_COVER);
    }

    public static String formatMM(double rain) {
        return "%s %s".formatted(rain, UNIT_MM);
    }


    public static String join(String delimiter, Object... objects) {
        if (objects.length == 0) return null;
        if (objects.length == 1) return String.valueOf(objects[0]);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < objects.length; i++) {
            Object object = objects[i];
            stringBuilder.append(object);
            if (i < objects.length - 1) {
                stringBuilder.append(delimiter);
            }
        }
        return stringBuilder.toString();
    }

    public static String formatSunriseAndSunset(long sunrise, long sunset) {
        return "%s - %s".formatted(DateTimeUtil.hourOfDay(sunrise), DateTimeUtil.hourOfDay(sunset));
    }

    public static String formatMaxAndMinTemperature(double temperatureMax, double temperatureMin) {
        return "%s - %s".formatted(temperature(temperatureMax), temperature(temperatureMin));
    }
}
