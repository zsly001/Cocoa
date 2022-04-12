package com.cocoa.mb.web.conf;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;


@Data
public class DataSource0Properties {

    @Value("${db0.poolName}")
    private String poolName;

    @Value("${db0.jdbcUrl}")
    private String jdbcUrl;

    @Value("${db0.dataSourceClassName}")
    private String dirver;

    @Value("${db0.username}")
    private String username;

    @Value("${db0.password}")
    private String password;

    @Value("${db0.connection-timeout:1000}")
    private Long connectionTimeout;

    @Value("${db0.initial-size:5}")
    private Integer maxPoolSize;

    @Value("${db0.min-idle:2}")
    private Integer minIdle;

}
