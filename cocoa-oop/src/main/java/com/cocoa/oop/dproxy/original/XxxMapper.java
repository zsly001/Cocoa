package com.cocoa.oop.dproxy.original;

import java.util.List;

public interface XxxMapper {

    List<Integer> getList();

    int count();

    default String info(){
        return "mapper info";
    }

}
