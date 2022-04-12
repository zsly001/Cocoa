package com.cocoa.mb.web.boot;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cocoa.mb.po.ActivityTag;
import com.cocoa.mb.web.conf.BeanScanConfig;
import com.cocoa.mb.web.conf.DbPlugConfig;
import com.cocoa.mb.web.service.CommonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main2 {

    private static final Logger log = LoggerFactory.getLogger(Main2.class);


    public static void main(String[] args) {
        ApplicationContext app = new AnnotationConfigApplicationContext(DbPlugConfig.class, BeanScanConfig.class);
        CommonService service = app.getBean(CommonService.class);
        /*Page<ActivityTag> page = service.getTags();
        log.info("{}",page);*/
        service.updateTage();
    }

}
