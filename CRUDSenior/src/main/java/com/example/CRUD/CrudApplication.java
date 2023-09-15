package com.example.CRUD;

import com.example.CRUD.config.AppConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication(scanBasePackages = "com.example")
@ComponentScan(basePackages = "com.example.*")
@EntityScan("com.example.*")
@EnableJpaRepositories(basePackages = "com.example.CRUD.repositories")
public class CrudApplication {
    
        protected static final Logger logger = LogManager.getLogger(CrudApplication.class);
        
        
        
    
        @Autowired
        private AppConfig config;

	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
                logger.info("Comienza la aplicacion");
	}
        
        @Bean
        public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/*").allowedOrigins(config.getAllowedOrigins())
                        .allowedMethods(config.getAllowedMethods())
                        .allowedHeaders(config.getAllowedHeaders());
            }
        };
    }

}
