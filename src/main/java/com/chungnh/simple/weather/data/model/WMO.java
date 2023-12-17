package com.chungnh.simple.weather.data.model;

import com.chungnh.simple.weather.utility.DateTimeUtil;

public class WMO {
    private Info day;
    private Info night;

    public Info getDay() {
        return day;
    }

    public void setDay(Info day) {
        this.day = day;
    }

    public Info getNight() {
        return night;
    }

    public void setNight(Info night) {
        this.night = night;
    }

    public Info get(boolean isDay) {
        return isDay ? day : night;
    }

    public Info get(long timestamp) {
        return DateTimeUtil.isDay(timestamp) ? day : night;
    }

    public static class Info {
        private final String description;
        private final String imageUrl;
        private final String imageLarge;

        public Info(String description, String imageUrl, String imageLarge) {
            this.description = description;
            this.imageUrl = imageUrl;
            this.imageLarge = imageLarge;
        }

        public Info(String description, String imageUrl) {
            this(description, imageUrl, null);
        }

        public String getDescription() {
            return description;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public String getImageLarge() {
            return imageLarge;
        }
    }
}
