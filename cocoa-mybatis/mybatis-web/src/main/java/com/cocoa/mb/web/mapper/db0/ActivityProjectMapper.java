package com.cocoa.mb.web.mapper.db0;

import com.cocoa.mb.po.ActivityProject;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

public interface ActivityProjectMapper {

    List<ActivityProject> getList(Map<String,Object> map);

    List<ActivityProject> selectByStatus(List<Integer> status);

    List<ActivityProject> selectList(List<ActivityProject> projects);


    int update(ActivityProject project);

}
