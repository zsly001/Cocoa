package com.cocoa.bean;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Util {

    /**
     * 摘自log4j2 org.apache.logging.log4j.core.util.TypeUtil#getAllDeclaredFields
     * @param cls
     * @return
     */
    public static List<Field> getAllDeclaredFields(Class<?> cls){
        final List<Field> fields = new ArrayList<>();
        Class tmp = cls;
        while (tmp!=null){
            Collections.addAll(fields,tmp.getDeclaredFields());
            tmp = tmp.getSuperclass();
        }
        return fields;
    }


}
