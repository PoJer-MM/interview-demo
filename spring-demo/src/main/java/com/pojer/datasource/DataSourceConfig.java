package com.pojer.datasource;

import com.pojer.constant.DataSourceType;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.LazyConnectionDataSourceProxy;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DataSourceConfig {

    @Bean
    public DataSource masterDataSource() {

        return DataSourceBuilder.create()
                .driverClassName("com.mysql.cj.jdbc.Driver")
                .url("jdbc:mysql://localhost:3306/p_master?useSSL=false&serverTimezone=UTC")
                .username("root")
                .password("1234pojer")
                .build();
    }

    @Bean
    public DataSource slaveDataSource() {

        return DataSourceBuilder.create()
                .driverClassName("com.mysql.cj.jdbc.Driver")
                .url("jdbc:mysql://localhost:3306/p_slave?useSSL=false&serverTimezone=UTC")
                .username("root")
                .password("1234pojer")
                .build();
    }

    @Primary
    @Bean
    public DataSource dataSource(
            @Qualifier("masterDataSource") DataSource master,
            @Qualifier("slaveDataSource") DataSource slave) {

        DynamicDataSource dynamicDataSource = new DynamicDataSource();

        Map<Object, Object> map = new HashMap<>();
        map.put(DataSourceType.MASTER.getValue(), master);
        map.put(DataSourceType.SLAVE.getValue(), slave);

        dynamicDataSource.setTargetDataSources(map);
        dynamicDataSource.setDefaultTargetDataSource(master);

        dynamicDataSource.afterPropertiesSet();

        return dynamicDataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

}
