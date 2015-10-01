package com.epam.reshetnev.memory.rest.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("api")
public class RestConfig extends ResourceConfig {

    public RestConfig() {

        packages("com.epam.reshetnev.memory.rest.resource",
                 /* Json providers */
                 "com.fasterxml.jackson.jaxrs.json",
                 /* Jackson exception mappers */
                 "com.fasterxml.jackson.jaxrs.base",
                 "com.wordnik.swagger.jersey.listing"
                );

    }

}
