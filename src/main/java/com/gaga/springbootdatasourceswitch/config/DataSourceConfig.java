package com.gaga.springbootdatasourceswitch.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.PathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * 数据源配置类
 * @Author fuGaga
 * @Date 2021/4/22 15:42
 * @Version 1.0
 */
@Configuration
//@MapperScan(basePackages = "com.gaga.springbootdatasourceswitch.dao",sqlSessionFactoryRef = "sqlSessionFactory")
@Slf4j
public class DataSourceConfig {

    //数据源0
    @Primary
    @Bean("db0DataSource")
    @ConfigurationProperties(prefix = "spring.datasource.ds0")
    public DataSource db0DataSource(){
        log.info("---加载ds0数据源----");
        return DruidDataSourceBuilder.create().build();
    }

    //数据源1
    @Bean("db1DataSource")
    @ConfigurationProperties(prefix = "spring.datasource.ds1")
    public DataSource db1DataSource(){
        log.info("---加载ds1数据源----");
        return DruidDataSourceBuilder.create().build();
    }

    //配置实际数据源与 选择数据源的映射关系
    @Bean("changeDataSourceConfig")
    public ChangeDataSourceConfig changeDataSourceConfig(@Qualifier("db0DataSource")DataSource db0DataSource,
                                                         @Qualifier("db1DataSource")DataSource db1DataSource){
        Map<Object, Object> targetDataSource = new HashMap<>();
        targetDataSource.put("db0", db0DataSource);
        targetDataSource.put("db1", db1DataSource);
        ChangeDataSourceConfig changeDataSourceConfig = new ChangeDataSourceConfig();
        changeDataSourceConfig.setTargetDataSources(targetDataSource);
        changeDataSourceConfig.setDefaultTargetDataSource(db0DataSource);

        return changeDataSourceConfig;
    }


    @Bean
    public SqlSessionFactory sqlSessionFactory(@Qualifier("changeDataSourceConfig") DataSource changeDataSourceConfig) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(changeDataSourceConfig);
        //sqlSessionFactoryBean.setConfiguration(new org.apache.ibatis.session.Configuration());
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/*.xml"));

        return sqlSessionFactoryBean.getObject();
    }

}
