package com.cocoa.mb.web.conf;


import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@PropertySource(name = "p1",value ={"classpath:application.properties"})
@MapperScan(basePackages = {"com.cocoa.mb.web.mapper.db1"},sqlSessionFactoryRef = "sf1",sqlSessionTemplateRef = "st1")
public class Db1Config implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Bean("dsp1")
    public DataSource1Properties dataSourceProperties1(){
        return new DataSource1Properties();
    }

    @Bean("ds1")
    public DataSource getDataSource1(@Qualifier("dsp1") DataSource1Properties properties){
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName(properties.getDirver());
        dataSource.setJdbcUrl(properties.getJdbcUrl());
        dataSource.setPoolName(properties.getPoolName());
        dataSource.setUsername(properties.getUsername());
        dataSource.setPassword(properties.getPassword());
        dataSource.setConnectionTimeout(properties.getConnectionTimeout());
        dataSource.setMaximumPoolSize(properties.getMaxPoolSize());
        dataSource.setMinimumIdle(properties.getMinIdle());
        return dataSource;
    }

    @Bean(name = "tm1")
    public DataSourceTransactionManager dataSourceTransactionManager1(@Qualifier("ds1") DataSource ds) {
        return new DataSourceTransactionManager(ds);
    }


    @Bean("sf1")
    public SqlSessionFactory sessionFactory1(@Qualifier("ds1") DataSource ds) throws Exception{
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setMapUnderscoreToCamelCase(true);
        sessionFactoryBean.setConfiguration(configuration);
        sessionFactoryBean.setDataSource(ds);
        sessionFactoryBean.setTypeAliasesPackage("com.cocoa.mb.po");
        sessionFactoryBean.setMapperLocations(resolver.getResources("classpath:mapper/db1/**.xml"));
        return sessionFactoryBean.getObject();
    }

    @Bean("st1")
    public SqlSessionTemplate sqlSessionTemplate1(@Qualifier("sf1") SqlSessionFactory factory){
        return new SqlSessionTemplate(factory);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
