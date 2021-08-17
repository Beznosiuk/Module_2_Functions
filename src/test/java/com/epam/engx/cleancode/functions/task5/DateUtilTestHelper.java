package com.epam.engx.cleancode.functions.task5;

import java.util.Date;

public final class DateUtilTestHelper {

    private DateUtilTestHelper() {
        throw new UnsupportedOperationException("Do not instantiate this class, use statically.");
    }

    public static Date getDirectlyIncrementedDate(DateService dateUtil, Date date) {
        return dateUtil.changeToMidnightDirectlyIncremented(date);
    }

    public static Date getInverseIncrementedDate(DateService dateUtil, Date date) {
        return dateUtil.changeToMidnightInverseIncremented(date);
    }
}
