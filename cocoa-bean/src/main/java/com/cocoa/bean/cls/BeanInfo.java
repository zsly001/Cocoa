package com.cocoa.bean.cls;

public interface BeanInfo<T> {

    default String info(){
        try {
            return BeanInfoBuilder.info(this);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }




}
