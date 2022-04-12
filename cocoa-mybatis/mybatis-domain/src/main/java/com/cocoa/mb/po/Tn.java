package com.cocoa.mb.po;

import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

@Data
public class Tn {

    private Integer id;

    private String name;

    private Date createAt;

    private Timestamp updateAt;

}
