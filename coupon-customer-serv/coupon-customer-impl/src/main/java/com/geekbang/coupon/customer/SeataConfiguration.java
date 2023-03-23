package com.geekbang.coupon.customer;

import com.alibaba.druid.pool.DruidDataSource;
import io.seata.rm.datasource.DataSourceProxy;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @author blake
 * @version 1.0
 * @description TODO
 * @date 2023/3/23 22:35
 */

@Configuration
public class SeataConfiguration {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DruidDataSource druidDataSource() {
        return new DruidDataSource();
    }

    @Bean("dataSource")
    @Primary
    public DataSource dataSourceDelegation(DruidDataSource druidDataSource) {
        return new DataSourceProxy(druidDataSource);
    }

}