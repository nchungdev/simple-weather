package com.chungnh.simple.weather.utility;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTimeUtil {
    private static final DateFormat FULL_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH':00'");
    private static final DateFormat SHORT_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    private static final DateFormat DAY_OF_WEEK_FORMAT = new SimpleDateFormat("EEEE, HH:mm");
    private static final DateFormat SIMPLE_DAY_OF_WEEK_FORMAT = new SimpleDateFormat("EEEE");
    private static final DateFormat HOUR_FORMAT = new SimpleDateFormat("H:mm");

    public static long convertToTimestamp(String string) {
        try {
            return FULL_DATE_FORMAT.parse(string).getTime();
        } catch (ParseException e) {
            try {
                return SHORT_DATE_FORMAT.parse(string).getTime();
            } catch (ParseException ex) {
                return 0;
            }
        }
    }

    public static String fullTime(long timestamp) {
        return DAY_OF_WEEK_FORMAT.format(new Date(timestamp * 1000));
    }

    public static String dayOfWeek(long timestamp) {
        return SIMPLE_DAY_OF_WEEK_FORMAT.format(new Date(timestamp * 1000));
    }

    public static String hourOfDay(long timestamp) {
        return HOUR_FORMAT.format(new Date(timestamp * 1000));
    }

    public static boolean isSinceNow(long time) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        int hour1 = calendar.get(Calendar.HOUR_OF_DAY);
        int date = calendar.get(Calendar.DATE);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(time * 1000);
        int date2 = calendar2.get(Calendar.DATE);
        int hour2 = calendar2.get(Calendar.HOUR_OF_DAY);
        return date2 >= date && hour2 >= hour1;
    }

    public static boolean isDay(long timestamp) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timestamp);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        return hour > 6 && hour < 18;
    }

    public static boolean isToday(long time) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        int date = calendar.get(Calendar.DATE);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(time * 1000);
        int date2 = calendar2.get(Calendar.DATE);
        return date2 == date;
    }
}
