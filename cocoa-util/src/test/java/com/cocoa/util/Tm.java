package com.cocoa.util;

import org.junit.Test;

import java.sql.Timestamp;
import java.util.Date;

public class Tm {


    @Test
    public void diff1(){
        Date ud = new Date();
        java.sql.Date sd = new java.sql.Date(System.currentTimeMillis());
        System.out.println("ud "+ ud +", ms : "+ud.getTime());
        System.out.println("sd "+sd +", ms : "+sd.getTime());

        Timestamp tp = new Timestamp(System.currentTimeMillis());
        System.out.println("tp "+ tp +", ms : "+tp.getTime());

    }

}
