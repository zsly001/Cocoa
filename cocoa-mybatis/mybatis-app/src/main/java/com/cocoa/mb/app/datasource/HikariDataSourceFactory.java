package com.cocoa.mb.app.datasource;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.datasource.unpooled.UnpooledDataSourceFactory;

import javax.sql.DataSource;

public class HikariDataSourceFactory extends UnpooledDataSourceFactory {

    public HikariDataSourceFactory() {
        this.dataSource = new HikariDataSource();
    }

    /*@Override
    public void setProperties(Properties properties) {
        System.out.println(properties);
        MetaObject metaDataSource = SystemMetaObject.forObject(this.dataSource);
        System.out.println(metaDataSource);
        String[] getterNames = metaDataSource.getGetterNames();
        String[] setterNames = metaDataSource.getSetterNames();
        Arrays.stream(getterNames).forEach(System.out::println);
        Arrays.stream(setterNames).forEach(System.out::println);
    }*/

    @Override
    public DataSource getDataSource() {
        return dataSource;
    }
}
