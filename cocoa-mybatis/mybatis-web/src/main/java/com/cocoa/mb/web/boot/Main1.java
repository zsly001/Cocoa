package com.cocoa.mb.web.boot;

import com.cocoa.mb.po.ActivityProject;
import com.cocoa.mb.po.ActivityTag;
import com.cocoa.mb.po.Tn;
import com.cocoa.mb.web.conf.Db0Config;
import com.cocoa.mb.web.conf.Db1Config;
import com.cocoa.mb.web.mapper.db0.ActivityProjectMapper;
import com.cocoa.mb.web.mapper.db0.ActivityTagMapper;
import com.cocoa.mb.web.mapper.db1.TnMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.List;


public class Main1 {

    private static final Logger log = LoggerFactory.getLogger(Main1.class);

    public static void main(String[] args) {
        ApplicationContext app = new AnnotationConfigApplicationContext(Db0Config.class,Db1Config.class);
        ActivityProjectMapper projectMapper = app.getBean(ActivityProjectMapper.class);
        PageHelper.startPage(1,5);
        List<ActivityProject> projects = projectMapper.selectByStatus(Arrays.asList(10));
        PageInfo<ActivityProject> page = new PageInfo<>(projects);
        log.info("{}",page);
        TnMapper tnMapper = app.getBean(TnMapper.class);
        Tn tn = tnMapper.get(1);
        System.out.println(tn);


    }

}
