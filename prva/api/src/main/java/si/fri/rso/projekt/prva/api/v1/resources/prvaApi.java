package si.fri.rso.projekt.prva.api.v1.resources;

import org.glassfish.jersey.process.internal.RequestScoped;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

//dont forget to run using this command
//docker run -d -p 8080:8080
// -> nek id + conzola se sportsti
// -p 8080:8080 preslika porte, da je možen dostop iz hosta

@RequestScoped
@Path("prvaTest")
public class prvaApi {
    @GET
    @Produces("text/plain")
    public String hello() {
        return "Hello from kumuluze. its working!";
    }

    @GET
    @Path("discovery")
    @Produces("text/plain")
    public String disc() {
        return "Hello from module PRVA!";
    }
}
