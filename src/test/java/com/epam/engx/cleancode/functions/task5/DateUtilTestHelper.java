package com.epam.engx.cleancode.functions.task5;

import java.util.Date;

public class DateUtilTestHelper {

    public static Date getDirectlyIncrementedDate(DateService dateUtil, Date date) {
        return dateUtil.changeToMidnightDirectlyIncremented(date);
    }

    public static Date getInverseIncrementedDate(DateService dateUtil, Date date) {
        return dateUtil.changeToMidnightInverseIncremented(date);
    }
}
