/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chungnh.simple.weather.data.model;

import java.util.List;

/**
 * @author chungnh
 */
public class Forecast {
    private double latitude;
    private double longitude;
    private String timezone;
    private Current current;
    private Hourly hourly;
    private Daily daily;

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public Current getCurrent() {
        return current;
    }

    public void setCurrent(Current current) {
        this.current = current;
    }

    public Hourly getHourly() {
        return hourly;
    }

    public void setHourly(Hourly hourly) {
        this.hourly = hourly;
    }

    public Daily getDaily() {
        return daily;
    }

    public void setDaily(Daily daily) {
        this.daily = daily;
    }

    public static class Current {

        private long time;
        private boolean isDay;
        private double temperature;
        private double precipitation;
        private double rain;
        private long weatherCode;
        private double windSpeed;
        private long relativeHumidity;

        public long getTime() {
            return time;
        }

        public void setTime(long time) {
            this.time = time;
        }

        public boolean isDay() {
            return isDay;
        }

        public void setDay(boolean day) {
            isDay = day;
        }

        public double getTemperature() {
            return temperature;
        }

        public void setTemperature(double temperature) {
            this.temperature = temperature;
        }

        public double getPrecipitation() {
            return precipitation;
        }

        public void setPrecipitation(double precipitation) {
            this.precipitation = precipitation;
        }

        public double getRain() {
            return rain;
        }

        public void setRain(double rain) {
            this.rain = rain;
        }

        public long getWeatherCode() {
            return weatherCode;
        }

        public void setWeatherCode(long weatherCode) {
            this.weatherCode = weatherCode;
        }

        public double getWindSpeed() {
            return windSpeed;
        }

        public void setWindSpeed(double windSpeed) {
            this.windSpeed = windSpeed;
        }

        public long getRelativeHumidity() {
            return relativeHumidity;
        }

        public void setRelativeHumidity(long relativeHumidity) {
            this.relativeHumidity = relativeHumidity;
        }
    }

    public static class Daily {
        private List<Long> time;
        private List<Long> weatherCodes;
        private List<Double> temperatureMax;
        private List<Double> temperatureMin;
        private List<Double> uvIndexMax;
        private List<Long> sunset;
        private List<Long> sunrise;
        private List<Double> rainSum;
        private List<Double> windSpeedMax;
        private List<Double> precipitationSum;

        public List<Long> getTime() {
            return time;
        }

        public void setTime(List<Long> time) {
            this.time = time;
        }

        public List<Long> getWeatherCodes() {
            return weatherCodes;
        }

        public void setWeatherCodes(List<Long> weatherCodes) {
            this.weatherCodes = weatherCodes;
        }

        public List<Double> getTemperatureMax() {
            return temperatureMax;
        }

        public void setTemperatureMax(List<Double> temperatureMax) {
            this.temperatureMax = temperatureMax;
        }

        public List<Double> getTemperatureMin() {
            return temperatureMin;
        }

        public void setTemperatureMin(List<Double> temperatureMin) {
            this.temperatureMin = temperatureMin;
        }

        public List<Double> getUvIndexMax() {
            return uvIndexMax;
        }

        public void setUvIndexMax(List<Double> uvIndexMax) {
            this.uvIndexMax = uvIndexMax;
        }

        public List<Long> getSunset() {
            return sunset;
        }

        public void setSunset(List<Long> sunset) {
            this.sunset = sunset;
        }

        public List<Long> getSunrise() {
            return sunrise;
        }

        public void setSunrise(List<Long> sunrise) {
            this.sunrise = sunrise;
        }

        public List<Double> getRainSum() {
            return rainSum;
        }

        public void setRainSum(List<Double> rainSum) {
            this.rainSum = rainSum;
        }

        public List<Double> getWindSpeedMax() {
            return windSpeedMax;
        }

        public void setWindSpeedMax(List<Double> windSpeedMax) {
            this.windSpeedMax = windSpeedMax;
        }

        public List<Double> getPrecipitationSum() {
            return precipitationSum;
        }

        public void setPrecipitationSum(List<Double> precipitationSum) {
            this.precipitationSum = precipitationSum;
        }
    }

    public static class Hourly {

        private List<Long> time;
        private List<Double> temperature;
        private List<Long> relativeHumidity;
        private List<Long> weatherCodes;
        private List<Long> cloudCover;
        private List<Double> windSpeed;
        private List<Double> rain;
        private List<Double> visibility;
        private List<Long> isDay;

        public List<Long> getTime() {
            return time;
        }

        public void setTime(List<Long> time) {
            this.time = time;
        }

        public List<Double> getTemperature() {
            return temperature;
        }

        public void setTemperature(List<Double> temperature) {
            this.temperature = temperature;
        }

        public List<Long> getRelativeHumidity() {
            return relativeHumidity;
        }

        public void setRelativeHumidity(List<Long> relativeHumidity) {
            this.relativeHumidity = relativeHumidity;
        }

        public List<Long> getCloudCover() {
            return cloudCover;
        }

        public void setCloudCover(List<Long> cloudCover) {
            this.cloudCover = cloudCover;
        }

        public List<Double> getWindSpeed() {
            return windSpeed;
        }

        public void setWindSpeed(List<Double> windSpeed) {
            this.windSpeed = windSpeed;
        }

        public List<Long> getWeatherCodes() {
            return weatherCodes;
        }

        public void setWeatherCodes(List<Long> weatherCodes) {
            this.weatherCodes = weatherCodes;
        }

        public List<Double> getRain() {
            return rain;
        }

        public void setRain(List<Double> rain) {
            this.rain = rain;
        }

        public List<Double> getVisibility() {
            return visibility;
        }

        public void setVisibility(List<Double> visibility) {
            this.visibility = visibility;
        }

        public List<Long> isDay() {
            return isDay;
        }

        public void setDay(List<Long> isDay) {
            this.isDay = isDay;
        }
    }

    @Override
    public String toString() {
        return "Weather{" + "latitude=" + latitude + ", longitude=" + longitude + ", timezone=" + timezone + ", current=" + current + ", hourly=" + hourly + ", daily=" + daily + '}';
    }
}
