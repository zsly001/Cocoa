package com.cocoa.mb.web.mapper.db1;

import com.cocoa.mb.po.Tn;
import org.apache.ibatis.annotations.Param;

public interface TnMapper {

    int save(Tn tm);

    Tn get(@Param("id") Integer id);

}
