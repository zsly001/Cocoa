package com.cocoa.mb.po;

import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

@Data
public class Tm {

    private Integer id;

    private Date startTime;

    private Timestamp endTime;

    private Date createAt;

    private Timestamp updateAt;

}
