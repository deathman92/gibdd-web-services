package ru.vlsu.gibdd.webservice.common.util;

import java.time.LocalDate;
import java.time.Year;

/**
 * @author Victor Zhivotikov
 * @since 01.04.2016
 */
public class DatatypeIoConverterUtils {

    public static LocalDate parseXSDDate(String lexicalXSDDate) {
        if (lexicalXSDDate == null || lexicalXSDDate.isEmpty()) {
            return null;
        }
        return LocalDate.parse(lexicalXSDDate);
    }

    public static String printXSDDate(LocalDate date) {
        return date.toString();
    }

    public static Year parseXSDYear(String lexicalXSDYear) {
        if (lexicalXSDYear == null || lexicalXSDYear.isEmpty()) {
            return null;
        }
        return Year.parse(lexicalXSDYear);
    }

    public static String printXSDYear(Year year) {
        return year.toString();
    }
}
