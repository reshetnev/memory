package com.epam.reshetnev.memory.core.config;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScan("com.epam.reshetnev.memory.core.config")
public class MvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void configureMessageConverters(final List<HttpMessageConverter<?>> converters) {

        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
        converters.add(mappingJackson2HttpMessageConverter);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/docs/**").addResourceLocations("/docs/");

        //dev
        registry.addResourceHandler("/*.html").addResourceLocations("/build/");
        registry.addResourceHandler("/assets/**").addResourceLocations("/build/assets/");
        registry.addResourceHandler("/src/**").addResourceLocations("/build/src/");
        registry.addResourceHandler("/vendor/**").addResourceLocations("/build/vendor/");
        registry.addResourceHandler("/templates-app.js").addResourceLocations("/build/");
        registry.addResourceHandler("/templates-common.js").addResourceLocations("/build/");

//        //prod
//        registry.addResourceHandler("/*.html").addResourceLocations("/bin/");
//        registry.addResourceHandler("/assets/**").addResourceLocations("/bin/assets/");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("forward:/index.html");
    }

}
