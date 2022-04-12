package com.cocoa.mb.web.conf;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;


@Data
public class DataSource1Properties {

    @Value("${db1.poolName}")
    private String poolName;

    @Value("${db1.jdbcUrl}")
    private String jdbcUrl;

    @Value("${db1.dataSourceClassName}")
    private String dirver;

    @Value("${db1.username}")
    private String username;

    @Value("${db1.password}")
    private String password;

    @Value("${db1.connection-timeout:1000}")
    private Long connectionTimeout;

    @Value("${db1.initial-size:5}")
    private Integer maxPoolSize;

    @Value("${db1.min-idle:2}")
    private Integer minIdle;

}
