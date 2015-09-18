package com.epam.reshetnev.memory.rest.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("api")
public class WebAppConfig extends ResourceConfig {

    public WebAppConfig() {
        packages("com.epam.reshetnev.memory.rest.resource"
                , "com.wordnik.swagger.jersey.listing"
                );
    }

}
