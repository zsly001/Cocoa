package com.cocoa.mb.web.mapper.db0;

import com.cocoa.mb.po.ActivityTag;
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
