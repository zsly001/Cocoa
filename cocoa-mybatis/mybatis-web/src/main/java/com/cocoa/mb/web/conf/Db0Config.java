package com.cocoa.mb.web.conf;

import com.github.pagehelper.PageInterceptor;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@PropertySource(name = "p0",value ={"classpath:application.properties"})
@MapperScan(basePackages = {"com.cocoa.mb.web.mapper.db0"},sqlSessionFactoryRef = "sf0",sqlSessionTemplateRef = "st0")
public class Db0Config {

    @Bean("dsp0")
    public DataSource0Properties dataSourceProperties0(){
        DataSource0Properties ds = new DataSource0Properties();
        return ds;
    }

    @Bean("ds0")
    public DataSource getDataSource0(@Qualifier("dsp0") DataSource0Properties properties){

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

    @Bean(name = "tm0")
    public DataSourceTransactionManager dataSourceTransactionManager0(@Qualifier("ds0") DataSource ds) {
        return new DataSourceTransactionManager(ds);
    }



    @Bean("sf0")
    public SqlSessionFactory sessionFactory0(@Qualifier("ds0") DataSource ds) throws Exception{
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setMapUnderscoreToCamelCase(true);
        sessionFactoryBean.setConfiguration(configuration);
        sessionFactoryBean.setDataSource(ds);
        sessionFactoryBean.setTypeAliasesPackage("com.cocoa.mb.po");
        sessionFactoryBean.setMapperLocations(resolver.getResources("classpath:mapper/db0/**.xml"));
        sessionFactoryBean.setPlugins(new PageInterceptor());
        return sessionFactoryBean.getObject();
    }

    @Bean("st0")
    public SqlSessionTemplate sqlSessionTemplate0(@Qualifier("sf0") SqlSessionFactory factory){
        return new SqlSessionTemplate(factory);
    }
}
