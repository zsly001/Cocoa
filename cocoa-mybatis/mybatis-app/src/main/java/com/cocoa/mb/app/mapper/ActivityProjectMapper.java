package com.cocoa.mb.app.mapper;

import com.cocoa.mb.app.po.ActivityProject;

import java.util.List;
import java.util.Map;

public interface ActivityProjectMapper {

    List<ActivityProject> getList(Map<String,Object> map);

    List<ActivityProject> selectByStatus(List<Integer> status);

    List<ActivityProject> selectList(List<ActivityProject> projects);


    int update(ActivityProject project);

}
