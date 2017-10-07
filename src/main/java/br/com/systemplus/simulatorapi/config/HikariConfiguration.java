package br.com.systemplus.simulatorapi.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class HikariConfiguration {

    @Bean
    @ConfigurationProperties(prefix="datasource.db-contract")
    public DataSource contractDataSource() {
        return DataSourceBuilder.create().build();
    }
}