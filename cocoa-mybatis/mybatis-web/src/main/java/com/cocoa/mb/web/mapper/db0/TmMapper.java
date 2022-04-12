package com.cocoa.mb.web.mapper.db0;

import com.cocoa.mb.po.Tm;
import org.apache.ibatis.annotations.Param;

public interface TmMapper {

    int save(Tm tm);

    Tm get(@Param("id") Integer id);

}
