package com.epam.reshetnev.memory.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.epam.reshetnev.memory.core.repository.config.DataConfig;

@Configuration
@Import({DataConfig.class})
@ComponentScan("com.epam.reshetnev.memory.core.service.impl")
public class RootConfig {

    // PropertySourcesPlaceholderConfigurer has to be static in order to kick in very early in the context initialization process.
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyPlaceHolderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
