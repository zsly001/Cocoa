package com.cocoa.mb.web.boot;

import com.cocoa.mb.web.bean.User;
import com.cocoa.mb.web.conf.BeanConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanMain {

    public static void main(String[] args) {
        ApplicationContext app = new AnnotationConfigApplicationContext(BeanConfig.class);
        BeanConfig bean = app.getBean(BeanConfig.class);
        System.out.println(bean.getName());
        User user = app.getBean(User.class);
        System.out.println(user);
    }

}
