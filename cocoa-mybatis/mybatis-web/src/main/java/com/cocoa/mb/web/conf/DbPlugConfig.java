package com.cocoa.mb.web.conf;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import com.github.pagehelper.PageInterceptor;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@PropertySource(name = "p0",value ={"classpath:application.properties"})
@MapperScan(basePackages = {"com.cocoa.mb.web.mapper.db0"},sqlSessionFactoryRef = "sf0",sqlSessionTemplateRef = "st0")
public class DbPlugConfig {

    @Bean("dsp")
    public DataSource0Properties dataSourceProperties(){
        DataSource0Properties ds = new DataSource0Properties();
        return ds;
    }

    @Bean("ds")
    public DataSource getDataSource(@Qualifier("dsp") DataSource0Properties properties){

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

    @Bean(name = "tm")
    public DataSourceTransactionManager dataSourceTransactionManager(@Qualifier("ds") DataSource ds) {
        return new DataSourceTransactionManager(ds);
    }


    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer scannerConfigurer = new MapperScannerConfigurer();
        scannerConfigurer.setBasePackage("com.cocoa.mb.web.mapper.db0");
        return scannerConfigurer;
    }


    @Bean("sf")
    public SqlSessionFactory sessionFactory(@Qualifier("ds") DataSource ds) throws Exception{
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        MybatisSqlSessionFactoryBean sessionFactoryBean = new MybatisSqlSessionFactoryBean();
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setMapUnderscoreToCamelCase(true);
        sessionFactoryBean.setDataSource(ds);
        sessionFactoryBean.setTypeAliasesPackage("com.cocoa.mb.po");
        sessionFactoryBean.setMapperLocations(resolver.getResources("classpath:mapper/db0/**.xml"));
        //sessionFactoryBean.setPlugins(new PaginationInnerInterceptor(DbType.MYSQL));
        return sessionFactoryBean.getObject();
    }

    @Bean("st0")
    public SqlSessionTemplate sqlSessionTemplate0(@Qualifier("sf") SqlSessionFactory factory){
        return new SqlSessionTemplate(factory);
    }
}
