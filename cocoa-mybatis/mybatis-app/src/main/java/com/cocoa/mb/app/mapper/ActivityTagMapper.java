package com.cocoa.mb.app.mapper;

import com.cocoa.mb.app.po.ActivityTag;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ActivityTagMapper {

    ActivityTag oneTag(@Param("id") Integer id);

    int save(ActivityTag tag);

    int updateStatus(@Param("id") Integer id,@Param("status") Integer status);

    int updateField(@Param("colum") String colum,@Param("colum_value")Object value,@Param("id") Integer id);

    List<ActivityTag> getList(@Param("colum") String colum,@Param("colum_value")Object value);

    int count(@Param("colum") String colum,@Param("colum_value")Object value);


}
