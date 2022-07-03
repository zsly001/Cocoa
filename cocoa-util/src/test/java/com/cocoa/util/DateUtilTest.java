package com.cocoa.util;

import com.cocoa.util.time.DateUtil;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class DateUtilTest {

    @Test
    public void eq(){
        Date dt1 = DateUtil.parseDateTime("2022-05-02 11:12:31");
        Date dt2 = DateUtil.parseDateTime("2022-05-02 23:12:31");
        Date dt3 = DateUtil.parseDateTime("2022-05-02 00:00:00");
        Date dt4 = DateUtil.parseDateTime("2021-05-02 11:12:31");
        Date dt5 = DateUtil.parseDateTime("2023-05-02 11:12:31");
        Date dt6 = DateUtil.parseDateTime("2023-05-03 11:12:31");
        Date dt7 = DateUtil.parseDateTime("2023-05-01 11:12:31");
        Assert.assertEquals(DateUtil.dateEq(dt1,dt2),DateUtil.dateEq2(dt1,dt2));
        Assert.assertEquals(DateUtil.dateEq(dt1,dt3),DateUtil.dateEq2(dt1,dt3));
        Assert.assertEquals(DateUtil.dateEq(dt1,dt4),DateUtil.dateEq2(dt1,dt4));
        Assert.assertEquals(DateUtil.dateEq(dt1,dt5),DateUtil.dateEq2(dt1,dt5));
        Assert.assertEquals(DateUtil.dateEq(dt5,dt6),DateUtil.dateEq2(dt5,dt6));
        Assert.assertEquals(DateUtil.dateEq(dt5,dt7),DateUtil.dateEq2(dt5,dt7));






    }

}
