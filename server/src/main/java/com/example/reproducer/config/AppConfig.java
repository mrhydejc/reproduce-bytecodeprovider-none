package com.example.reproducer.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.example.reproducer.dao")
@EntityScan(basePackages = {"com.example.base", "com.example.reproducer.model"})
@ComponentScan({ "com.example.reproducer" })
@Configuration
public class AppConfig {
    
}
