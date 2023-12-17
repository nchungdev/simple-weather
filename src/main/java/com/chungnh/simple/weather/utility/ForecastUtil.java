package com.chungnh.simple.weather.utility;

import com.chungnh.simple.weather.data.model.Forecast;
import com.chungnh.simple.weather.data.model.ListDaily;

import java.util.List;

public class ForecastUtil {
    public static ListDaily.Item getCurrent(Forecast.Daily daily) {
        List<Long> time = daily.getTime();
        for (int i = 0; i < time.size(); i++) {
            Long l = time.get(i);
            if (DateTimeUtil.isToday(l)) {
                return MappingUtil.dailyToSingle(daily, i);
            }
        }
        return null;
    }
}
