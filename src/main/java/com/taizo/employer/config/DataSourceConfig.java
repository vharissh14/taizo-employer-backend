package com.taizo.employer.config;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;


@Configuration
public class DataSourceConfig {

    @Autowired
    private Environment env;

    private static final Logger logger = LogManager.getLogger(DataSourceConfig.class);

    public DataSourceConfig(Environment env) {
        logger.info("the env is "+env.toString());
        this.env = env;
    }

    @Bean
    public DataSource getDataSource() throws Exception {
        logger.info("Hikari Configurations Loading ...");
        final HikariDataSource ds = new HikariDataSource();
        ds.setMaximumPoolSize(Integer.parseInt(env.getProperty("spring.datasource.hikari.maximumPoolSize", "10")));
        ds.setMaxLifetime(Integer.parseInt(env.getProperty("spring.datasource.hikari.maxLifetime", "6000000")));
        ds.setAutoCommit(Boolean.parseBoolean(env.getProperty("spring.datasource.hikari.autoCommit", "true")));
        ds.setConnectionTimeout(Long.parseLong(env.getProperty("spring.datasource.hikari.connectionTimeout","30000")));
        ds.setIdleTimeout(Long.parseLong(env.getProperty("spring.datasource.hikari.idleTimeout", "600000")));
        ds.setDataSourceClassName("org.postgresql.ds.PGSimpleDataSource");
        ds.addDataSourceProperty("url", env.getProperty("spring.datasource.url"));
        ds.addDataSourceProperty("user", env.getProperty("spring.datasource.username"));
        ds.addDataSourceProperty("password", env.getProperty("spring.datasource.password"));
        return ds;
    }
}

