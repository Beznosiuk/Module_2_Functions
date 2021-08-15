package com.epam.engx.cleancode.functions.task5;

import java.util.Calendar;
import java.util.Date;

import static java.util.Calendar.DATE;
import static java.util.Calendar.HOUR_OF_DAY;
import static java.util.Calendar.MILLISECOND;
import static java.util.Calendar.MINUTE;
import static java.util.Calendar.SECOND;
import static java.util.Calendar.getInstance;

public class DateService {

    private static final int ZERO_VALUE = 0;

    public Date changeToMidnightDirectlyIncremented(Date date) {
        Calendar calendar = getInstance();
        calendar.setTime(date);
        calendar.add(DATE, 1);
        setMidnightTime(calendar);
        return calendar.getTime();
    }

    public Date changeToMidnightInverseIncremented(Date date) {
        Calendar calendar = getInstance();
        calendar.setTime(date);
        calendar.add(DATE, -1);
        setMidnightTime(calendar);
        return calendar.getTime();
    }

    private void setMidnightTime(Calendar calendar) {
        int[] midnightTimeFields = new int[]{HOUR_OF_DAY, MINUTE, SECOND, MILLISECOND};
        for (int timeField : midnightTimeFields) {
            calendar.set(timeField, ZERO_VALUE);
        }
    }
}
