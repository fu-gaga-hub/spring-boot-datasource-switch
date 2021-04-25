package com.gaga.springbootdatasourceswitch.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.stereotype.Component;

/**
 * 继承AbstractRoutingDataSource动态切换数据源
 * @Author fuGaga
 * @Date 2021/4/22 15:55
 * @Version 1.0
 */
public class ChangeDataSourceConfig extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        String key = ThreadLocalDataSource.getDbKey();
        return key;
    }
}
