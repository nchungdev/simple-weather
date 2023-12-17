package com.chungnh.simple.weather.data.model;

import java.util.ArrayList;

public class ListHourly extends ArrayList<ListHourly.Item> {
    public static class Item {
        private long time;
        private String timeString;
        private double temperature;
        private long relativeHumidity;
        private long weatherCode;
        private long cloudCover;
        private double windSpeed;
        private double rain;
        private double visibility;
        private boolean isDay;

        public long getTime() {
            return time;
        }

        public void setTime(long time) {
            this.time = time;
        }

        public String getTimeString() {
            return timeString;
        }

        public void setTimeString(String timeString) {
            this.timeString = timeString;
        }

        public double getTemperature() {
            return temperature;
        }

        public void setTemperature(double temperature) {
            this.temperature = temperature;
        }

        public long getRelativeHumidity() {
            return relativeHumidity;
        }

        public void setRelativeHumidity(long relativeHumidity) {
            this.relativeHumidity = relativeHumidity;
        }

        public long getWeatherCode() {
            return weatherCode;
        }

        public void setWeatherCode(long weatherCode) {
            this.weatherCode = weatherCode;
        }

        public long getCloudCover() {
            return cloudCover;
        }

        public void setCloudCover(long cloudCover) {
            this.cloudCover = cloudCover;
        }

        public double getWindSpeed() {
            return windSpeed;
        }

        public void setWindSpeed(double windSpeed) {
            this.windSpeed = windSpeed;
        }

        public double getRain() {
            return rain;
        }

        public void setRain(double rain) {
            this.rain = rain;
        }

        public double getVisibility() {
            return visibility;
        }

        public void setVisibility(double visibility) {
            this.visibility = visibility;
        }

        public boolean isDay() {
            return isDay;
        }

        public void setDay(boolean day) {
            isDay = day;
        }
    }
}