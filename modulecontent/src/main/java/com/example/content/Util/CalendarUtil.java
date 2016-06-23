package com.example.content.Util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by M. Asrof Bayhaqqi on 6/22/2016.
 */
public class CalendarUtil {
    public static Calendar calendar = Calendar.getInstance();



    public static String getTime() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        String time = simpleDateFormat.format(calendar.getTime());
        return time;
    }

    public static String getDay() {
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        String nameDay = null;

        switch (day) {
            case Calendar.SUNDAY:
                nameDay = "sunday";
                break;
            case Calendar.MONDAY:
                nameDay = "monday";
                break;
            case Calendar.TUESDAY:
                nameDay = "tuesday";
                break;
            case Calendar.WEDNESDAY:
                nameDay = "wednesday";
                break;
            case Calendar.THURSDAY:
                nameDay = "thursday";
                break;
            case Calendar.FRIDAY:
                nameDay = "friday";
                break;
            case Calendar.SATURDAY:
                nameDay = "saturday";
                break;
        }
        return nameDay;
    }
}
