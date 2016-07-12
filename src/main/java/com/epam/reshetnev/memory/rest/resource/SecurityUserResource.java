package com.epam.reshetnev.memory.rest.resource;

import java.security.Principal;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;

@Path("/v1/users/principal")
@Singleton
public class SecurityUserResource {
    // Jersey will inject proxy of Security Context
    @Context
    SecurityContext securityContext;
 
    @GET
    public Principal getUserPrincipal() {
        Principal principal = securityContext.getUserPrincipal();
        return principal;
    }
}
