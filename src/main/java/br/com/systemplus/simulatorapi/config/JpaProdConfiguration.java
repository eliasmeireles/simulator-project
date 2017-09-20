package br.com.systemplus.simulatorapi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.net.URISyntaxException;
import java.util.Properties;

@Configuration
public class JpaProdConfiguration {

    @Autowired
    private Environment environment;

    @Bean
    public Properties additionalProperties() {
        Properties props = new Properties();
        props.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        props.setProperty("hibernate.show_sql", "true");
        props.setProperty("hibernate.hbm2ddl.auto", "update");
        return props;
    }

    /*Configuração banco de produção*/
//    @Bean
//    public DataSource dataSource() throws URISyntaxException {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("org.postgresql.Driver");
//        URI dbUrl = new URI(environment.getProperty("DATABASE_URL"));
//
//        dataSource.setUrl("jdbc:postgresql://" + dbUrl.getHost() + ":" + dbUrl.getPort() + dbUrl.getPath());
//        dataSource.setUsername(dbUrl.getUserInfo().split(":")[0]);
//        dataSource.setPassword(dbUrl.getUserInfo().split(":")[1]);
//        return dataSource;
//    }

    /*Configuração para banco local*/
    @Bean
    public DataSource dataSource() throws URISyntaxException {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");

        dataSource.setUrl("jdbc:postgresql://localhost:5432/simulator_data");
        dataSource.setUsername("postgres");
        dataSource.setPassword("root");
        return dataSource;
    }

}
