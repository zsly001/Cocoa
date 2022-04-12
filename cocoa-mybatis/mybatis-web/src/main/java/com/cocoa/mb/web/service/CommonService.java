package com.cocoa.mb.web.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cocoa.mb.po.ActivityTag;
import com.cocoa.mb.web.mapper.db0.ActivityTagPlugMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class CommonService {

    @Resource
    private ActivityTagPlugMapper activityTagPlugMapper;

    public Page<ActivityTag> getTags(){
        Page<ActivityTag> page = Page.of(1,10);
        QueryWrapper<ActivityTag> query = new QueryWrapper<ActivityTag>().eq("status",0);
        return activityTagPlugMapper.selectPage(page, query);

    }


    @Transactional
    public void updateTage(){
        ActivityTag tag1 = new ActivityTag();
        tag1.setName("xx1");
        ActivityTag tag2 = new ActivityTag();
        tag2.setName("xx2");
        activityTagPlugMapper.insert(tag1);
        System.out.println(1/0);
        activityTagPlugMapper.insert(tag2);
    }

}
