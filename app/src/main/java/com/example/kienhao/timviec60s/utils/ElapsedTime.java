package com.example.kienhao.timviec60s.utils;

import java.text.SimpleDateFormat;
import java.util.TimeZone;

/**
 * Created by KienHao on 2/13/2018.
 */

public class ElapsedTime {
    public static String convertLongToDate(long date, String dateFormat) {
        SimpleDateFormat df = new SimpleDateFormat(dateFormat);
        df.setTimeZone(TimeZone.getTimeZone("GMT+7:00"));
        return df.format(date);
    }

    public static String parseMStoTimer(long ms){
        int hour = (int) ((ms / (1000*60*60)) % 24);

        if (hour != 0){
            SimpleDateFormat df = new SimpleDateFormat("hh:mm:ss");
            df.setTimeZone(TimeZone.getTimeZone("GMT+7:00"));
            return df.format(ms);
        }
        SimpleDateFormat df = new SimpleDateFormat("mm:ss");
        df.setTimeZone(TimeZone.getTimeZone("GMT+7:00"));
        return df.format(ms);
    }
}
