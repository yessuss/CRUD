package com.example.CRUD.config;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import javax.sql.DataSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

/**
 *
 * @author Jesus Aispuro
 */
@Configuration
@Component
@ConfigurationProperties(prefix = "app")
@AllArgsConstructor
@NoArgsConstructor
@Data public class AppConfig {
     protected String authUri;
    protected boolean ignoreSession;
    protected String allowedOrigins = "*";
    protected String allowedMethods = "GET, POST, PUT, DELETE, OPTIONS";
    protected String allowedHeaders = "Access-Control-Allow-Origin, Access-Control-Allow-Headers, Access-Control-Allow-Methods, Accept, "
                                      + "Authorization, Content-Type, Method, Origin, X-Forwarded-For, X-Real-IP";
    
    @Bean(name = {"ds"})
    public DataSource getDataSource(){
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("org.postgresql.Driver");
        ds.setUrl("jdbc:postgresql://localhost:5432/CRUD");
        ds.setUsername("postgres");
        ds.setPassword("1234");
        return ds;
    }
    
    @Bean(name={"jdbcTemplate"})
    public JdbcTemplate getTemplate(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(getDataSource());
        return jdbcTemplate;
    }
}
