package com.epam.reshetnev.memory.rest.config.swagger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.wordnik.swagger.jaxrs.config.BeanConfig;

@WebListener
public class SwaggerInitializer implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        BeanConfig config = new BeanConfig();
        config.setVersion("1.0.2");
        config.setResourcePackage("com.epam.reshetnev.memory.rest.resource");
        config.setBasePath("http://localhost:8080/memory/api");
        config.setScan(true);

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }

}
