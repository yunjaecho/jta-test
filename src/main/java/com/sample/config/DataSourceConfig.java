package com.sample.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * Created by USER on 2017-12-29.
 */
@Configuration
@EnableConfigurationProperties
@EnableAutoConfiguration
public class DataSourceConfig {
    @Bean(name = "dataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.jta.atomikos.datasource.posmall")
    public DataSource dataSourcePosmall() {
        return new AtomikosDataSourceBean();
    }

    @Bean(name = "dataSourceWebcache")
    @ConfigurationProperties(prefix = "spring.jta.atomikos.datasource.webcache")
    public DataSource dataSourceWebcache() {
        return new AtomikosDataSourceBean();
    }
}
