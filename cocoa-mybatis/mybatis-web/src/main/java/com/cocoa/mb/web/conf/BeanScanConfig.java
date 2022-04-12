package com.cocoa.mb.web.conf;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.cocoa.mb.web.service"})
public class BeanScanConfig {
}
