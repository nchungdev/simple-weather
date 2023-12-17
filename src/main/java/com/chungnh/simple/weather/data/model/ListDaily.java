package com.chungnh.simple.weather.data.model;

import java.util.ArrayList;

public class ListDaily extends ArrayList<ListDaily.Item> {
    public static class Item {
        private long time;
        private double temperatureMax;
        private double temperatureMin;
        private double uvIndexMax;
        private long weatherCode;
        private long sunset;
        private long sunrise;
        private double rainSum;
        private double windSpeedMax;
        private double precipitationSum;

        public long getTime() {
            return time;
        }

        public void setTime(long time) {
            this.time = time;
        }

        public double getTemperatureMax() {
            return temperatureMax;
        }

        public void setTemperatureMax(double temperatureMax) {
            this.temperatureMax = temperatureMax;
        }

        public double getTemperatureMin() {
            return temperatureMin;
        }

        public void setTemperatureMin(double temperatureMin) {
            this.temperatureMin = temperatureMin;
        }

        public double getUvIndexMax() {
            return uvIndexMax;
        }

        public void setUvIndexMax(double uvIndexMax) {
            this.uvIndexMax = uvIndexMax;
        }

        public long getWeatherCode() {
            return weatherCode;
        }

        public void setWeatherCode(long weatherCode) {
            this.weatherCode = weatherCode;
        }

        public long getSunset() {
            return sunset;
        }

        public void setSunset(long sunset) {
            this.sunset = sunset;
        }

        public long getSunrise() {
            return sunrise;
        }

        public void setSunrise(long sunrise) {
            this.sunrise = sunrise;
        }

        public double getRainSum() {
            return rainSum;
        }

        public void setRainSum(double rainSum) {
            this.rainSum = rainSum;
        }

        public double getWindSpeedMax() {
            return windSpeedMax;
        }

        public void setWindSpeedMax(double windSpeedMax) {
            this.windSpeedMax = windSpeedMax;
        }

        public double getPrecipitationSum() {
            return precipitationSum;
        }

        public void setPrecipitationSum(double precipitationSum) {
            this.precipitationSum = precipitationSum;
        }
    }
}