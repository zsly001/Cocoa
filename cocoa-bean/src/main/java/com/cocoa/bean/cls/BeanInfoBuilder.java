package com.cocoa.bean.cls;

import com.cocoa.bean.Util;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.util.List;

public class BeanInfoBuilder {

    private static final Field[] EMPTY_FIELD_ARRAY = new Field[] {};

    /**
     * 摘自log4j2 org.apache.logging.log4j.core.config.plugins.util.PluginBuilder#validateFields
     * @param beanInfo
     * @return
     * @throws IllegalAccessException
     */
    public static String info(BeanInfo<?> beanInfo) throws IllegalAccessException{
        List<Field> fields = Util.getAllDeclaredFields(beanInfo.getClass());
        AccessibleObject.setAccessible(fields.toArray(EMPTY_FIELD_ARRAY), true);
        StringBuilder sb = new StringBuilder("bean info is [");
        for(Field field : fields){
            Object value = field.get(beanInfo);
            sb.append(field.getName()).append("=").append(value).append(",").append("\n");
        }
        sb.append("]");
        return sb.toString();
    }


}
