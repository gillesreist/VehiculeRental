package fr.ecoleNum.VehiculeRental.service.util;

import fr.ecoleNum.VehiculeRental.exception.InvalidPeriodDateException;

import java.sql.Timestamp;
import java.util.Calendar;

import static java.util.Calendar.*;

public class DateFunctions {

    public static int getAge(Timestamp t1) {

        Calendar calClient = Calendar.getInstance();
        calClient.setTimeInMillis(t1.getTime());

        Calendar today = Calendar.getInstance();

        int age = today.get(YEAR) - calClient.get(YEAR);
        if (calClient.get(MONTH) > today.get(MONTH) ||
                (
                        calClient.get(MONTH) == today.get(MONTH) &&
                                calClient.get(DATE) > today.get(DATE)
                )
        ) {
            age--;
        }
        return age;
    }

    public static boolean areDistinctPeriods(Timestamp period1Start, Timestamp period1End, Timestamp period2Start, Timestamp period2End) {

        return false;
    }
}
