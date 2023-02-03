package org.acme;

import java.security.Principal;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;

@Path("/hello")
public class GreetingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from RESTEasy Reactive";
    }
    

    @Path("/private")    
    @RolesAllowed("**")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String helloConnected(@Context SecurityContext user) {
        return "Hello " + user.getUserPrincipal().getName();
    }
}