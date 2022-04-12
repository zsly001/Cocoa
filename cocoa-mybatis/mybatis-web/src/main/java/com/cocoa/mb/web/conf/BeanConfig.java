package com.cocoa.mb.web.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("application.properties")
public class BeanConfig {

    @Value("${v.name}")
    private String name;


    /*@Bean
    public User user(){
        return new User();
    }*/

    public String getName(){
        return name;
    }

}
