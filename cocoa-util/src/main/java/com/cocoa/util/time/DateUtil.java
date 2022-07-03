package com.cocoa.util.time;

import java.time.*;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DateUtil {

    private static final String DEFAULT_DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    private static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";


    public static long intealDays(Date start , Date end){
        LocalDate ld1 = toLocalDate(start);
        LocalDate ld2 = toLocalDate(end);
        return Period.between(ld1, ld2).getDays();
    }

    public static long intealDays2(Date start , Date end){
        LocalDate ld1 = toLocalDate(start);
        LocalDate ld2 = toLocalDate(end);
        return ChronoUnit.DAYS.between(ld1,ld2);
    }

    public static long intealDays3(Date start , Date end){
        LocalDate ld1 = toLocalDate(start);
        LocalDate ld2 = toLocalDate(end);
        return ld2.toEpochDay()-ld1.toEpochDay();
    }


    public static long getIntealDays(Date start , Date end){
        LocalDate ld1 = toLocalDate(start);
        LocalDate ld2 = toLocalDate(end);
        List<String> query = ld1.query(new TemporalQuery<List<String>>() {
            @Override
            public List<String> queryFrom(TemporalAccessor temporal) {
                System.out.println("TemporalAccessor is "+temporal);
                LocalDate d = LocalDate.from(temporal);
                List<String> result = new ArrayList<>();
                LocalDate temp = d;
                while (d.isBefore(ld2)||d.isEqual(ld2)){
                    temp = d;
                    result.add(temp.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
                    d = d.plusDays(1L);

                }
                return result;
            }
        });
        query.forEach(System.out::println);
        //units.forEach(System.out::println);
        return query.size();
    }

    public static String getFirstDayOfMouth(Date date){
        LocalDate ld = toLocalDate(date);
        LocalDate rd = ld.with(TemporalAdjusters.firstDayOfMonth());
        System.out.println("ld == rd :"+(ld==rd));
        return rd.format(DateTimeFormatter.ofPattern(DEFAULT_DATE_FORMAT));
    }


    public static boolean dateEq(Date date1,Date date2){
        LocalDate ld1 = toLocalDate(date1);
        LocalDate ld2 = toLocalDate(date2);
        return ld1.isEqual(ld2);
    }

    public static boolean dateEq2(Date date1,Date date2){
        LocalDateTime ldt1 = toLocalDateTime(date1);
        LocalDateTime ldt2 = toLocalDateTime(date2);
        return (ChronoUnit.DAYS.between(ldt1,ldt2)==0);
    }



    public static Date parseDateTime(String date){
        return parse(date,DEFAULT_DATE_TIME_FORMAT);
    }

    /*public static Date parseDate(String dateStr){
        return parseDate(dateStr,DEFAULT_DATE_FORMAT);
    }*/

   /* public static Date parseDate(String dateStr,String pattern){
        LocalDate ld = LocalDate.parse(dateStr,DateTimeFormatter.ofPattern(pattern));
        ld.
        return ));
    }*/

    public static Date parse(String dateTimeStr,String pattern){
        return Date.from(LocalDateTime.parse(dateTimeStr,DateTimeFormatter.ofPattern(pattern)).atZone(ZoneId.systemDefault()).toInstant());
    }

    public static String formatDateTime(Date date){
        return format(date,DEFAULT_DATE_TIME_FORMAT);
    }

    public static String formatDateTimeOfDayStart(Date date){
        LocalDateTime ldt = toLocalDateTime(date);
        ldt = ldt.withHour(0).withMinute(0).withSecond(0);
        return format(ldt,DEFAULT_DATE_TIME_FORMAT);
    }

    public static String formatDateTimeOfDayEnd(Date date){
        LocalDateTime ldt = toLocalDateTime(date);
        ldt = ldt.withHour(23).withMinute(59).withSecond(59);
        return format(ldt,DEFAULT_DATE_TIME_FORMAT);
    }

    public static String formatDate(Date date){
        return format(date,DEFAULT_DATE_FORMAT);
    }


    public static List<Date>ofDayStartAndEnd(String dataStr){
        List<Date> datetimes = new ArrayList<>();
        LocalDate ldt = LocalDate.parse(dataStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDateTime startOfDay = ldt.atStartOfDay();
        datetimes.add(toDate(startOfDay));
        LocalDateTime endOfDay = startOfDay.withHour(23).withMinute(59).withSecond(59);
        datetimes.add(toDate(endOfDay));
        return datetimes;
    }

    public static Date toDate(LocalDateTime ldt){
        return Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static String formatDateTimeByMillis(long millis){
        return format(toLocalDateTime(millis),DEFAULT_DATE_TIME_FORMAT);
    }

    public static String formatDateByMillis(long millis){
        return format(toLocalDateTime(millis),DEFAULT_DATE_FORMAT);
    }

    public static String format(LocalDateTime ldt,String pattern){
        return ldt.format(DateTimeFormatter.ofPattern(pattern));
    }

    public static String format(Date date, String pattern){
        return toLocalDateTime(date).format(DateTimeFormatter.ofPattern(pattern));
    }

    public static Date toDate(long millis){
        return new Date(millis);
    }

    public static LocalDateTime toLocalDateTime(long millis){
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(millis),ZoneId.systemDefault());
    }

    public static LocalDateTime toLocalDateTime(Date date){
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    public static LocalDate toLocalDate(Date date){
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public static void main(String[] args) {


        /*long millis = System.currentTimeMillis();
        System.out.println(DateUtil.formatDateTime(new Date(millis)));
        System.out.println(DateUtil.formatDate(new Date(millis)));
        System.out.println(DateUtil.formatDateTimeByMillis(millis));
        System.out.println(DateUtil.formatDateByMillis(millis));

        System.out.println("----------");
        System.out.println(DateUtil.parse("2022-05-10 12:12:59","yyyy-MM-dd HH:mm:ss"));
        *//*System.out.println(DateUtil.parseDate("2022-05-10"));
        System.out.println(DateUtil.formatDate());*//*
        System.out.println(DateUtil.formatDateTimeOfDayStart(new Date()));
        System.out.println(DateUtil.formatDateTimeOfDayEnd(new Date()));

        Date dt1 = DateUtil.parseDateTime("2022-05-02 11:12:31");
        Date dt2 = DateUtil.parseDateTime("2022-05-02 23:12:31");
        Date dt3 = DateUtil.parseDateTime("2022-05-02 00:00:00");
        Date dt4 = DateUtil.parseDateTime("2021-05-02 11:12:31");
        Date dt5 = DateUtil.parseDateTime("2023-05-02 11:12:31");
        Date dt6 = DateUtil.parseDateTime("2023-05-03 11:12:31");
        Date dt7 = DateUtil.parseDateTime("2023-05-01 11:12:31");
        Date dt8 = DateUtil.parseDateTime("2023-05-07 00:12:31");
        System.out.println("=========");
        System.out.println(String.format("%s : [%s,%s]",DateUtil.formatDate(dt1),DateUtil.formatDateTimeOfDayStart(dt1),DateUtil.formatDateTimeOfDayEnd(dt1)));
        System.out.println(String.format("%s : [%s,%s]",DateUtil.formatDate(dt2),DateUtil.formatDateTimeOfDayStart(dt2),DateUtil.formatDateTimeOfDayEnd(dt2)));
        System.out.println(String.format("%s : [%s,%s]",DateUtil.formatDate(dt3),DateUtil.formatDateTimeOfDayStart(dt3),DateUtil.formatDateTimeOfDayEnd(dt3)));
        System.out.println(String.format("%s : [%s,%s]",DateUtil.formatDate(dt4),DateUtil.formatDateTimeOfDayStart(dt4),DateUtil.formatDateTimeOfDayEnd(dt4)));
        System.out.println(String.format("%s : [%s,%s]",DateUtil.formatDate(dt5),DateUtil.formatDateTimeOfDayStart(dt5),DateUtil.formatDateTimeOfDayEnd(dt5)));

        System.out.println("-----------------");
        System.out.println(String.format("dt1 eq dt2 ? %s",DateUtil.dateEq(dt1,dt2)));
        System.out.println(String.format("dt1 eq dt3 ? %s",DateUtil.dateEq(dt1,dt3)));
        System.out.println(String.format("dt1 eq dt4 ? %s",DateUtil.dateEq(dt1,dt4)));
        System.out.println(String.format("dt1 eq dt5 ? %s",DateUtil.dateEq(dt1,dt5)));
        System.out.println(String.format("dt5 eq dt6 ? %s",DateUtil.dateEq(dt5,dt6)));
        System.out.println(String.format("dt5 eq dt7 ? %s",DateUtil.dateEq(dt5,dt7)));

        System.out.println("-----------");
        System.out.println(DateUtil.getFirstDayOfMouth(new Date()));
        System.out.println(DateUtil.intealDays(dt1,dt8));
        System.out.println(DateUtil.intealDays2(dt1,dt8));
        System.out.println(DateUtil.intealDays3(dt1,dt8));
        System.out.println("--------");
        System.out.println(DateUtil.getIntealDays(dt1,dt8));*/

        LocalDate date = LocalDate.parse("2022-05-01", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        System.out.println(date);
        System.out.println(date.atStartOfDay());
        LocalDateTime startOfDay = date.atStartOfDay();
        System.out.println(startOfDay);
        System.out.println("------");
        System.out.println(DateUtil.ofDayStartAndEnd("2022-05-30"));



    }




}
