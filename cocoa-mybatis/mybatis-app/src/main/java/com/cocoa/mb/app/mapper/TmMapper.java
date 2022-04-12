package com.cocoa.mb.app.mapper;

import com.cocoa.mb.po.Tm;
import org.apache.ibatis.annotations.Param;

public interface TmMapper {

    int save(Tm tm);

    Tm get(@Param("id") Integer id);

}
