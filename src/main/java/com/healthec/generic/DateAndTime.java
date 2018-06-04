package com.healthec.generic;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateAndTime {

    public static String thrownDateAndTime ()  {

        LocalDateTime datetime = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm-ss");
        String formatDateTime = datetime.format(format);
        System.out.println(formatDateTime);
        return formatDateTime;
    }

    public static void main(String[] args) {

       String dt=  thrownDateAndTime();
    }
}
