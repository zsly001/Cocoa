package com.cocoa.util.time;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class J8Datetime {

    public static void zoned(){
        System.out.println("system zone is "+ZoneId.systemDefault());
        ZoneId zd1 = ZoneId.from(LocalDateTime.now().atZone(ZoneId.systemDefault()));
        System.out.println(zd1);
        System.out.println(ZoneId.of("Asia/Tokyo"));


        //ZoneId.getAvailableZoneIds().forEach(System.out::println);

    }

    public static void convert(){
        Date date = new Date();
        ZonedDateTime zone = date.toInstant().atZone(ZoneId.systemDefault());
        LocalDate localDate = zone.toLocalDate();
        LocalTime localTime = zone.toLocalTime();
        LocalDateTime ldt1 = zone.toLocalDateTime();
        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(ldt1);
        System.out.println(date);

        System.out.println("===");
        ZonedDateTime zonedDateTime = Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault());
        System.out.println(zone);
        System.out.println(zonedDateTime);
        LocalDateTime ldt2 = zonedDateTime.toLocalDateTime();
        LocalDateTime ldt3 = ldt2.plusHours(10);
        System.out.println(ChronoUnit.DAYS.between(ldt1, ldt3));
        System.out.println(ChronoUnit.HOURS.between(ldt1,ldt3));

        System.out.println("===");
        LocalDateTime ldt = LocalDateTime.parse("2022-05-22 13:06:59", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(ChronoUnit.DAYS.between(ldt,ldt1));

        String ds = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(ds);

        long nowMillis = System.currentTimeMillis();
        LocalDateTime ldt5 = LocalDateTime.ofInstant(Instant.ofEpochMilli(nowMillis), ZoneId.systemDefault());
        System.out.println(ldt5.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        Date dt = new Date(nowMillis);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(dt));
    }

    public static void plus(){

    }


    public static void main(String[] args) {
        //zoned();
        convert();
    }


}
