package si.fri.rso.projekt.prva.api.v1.resources;

import org.glassfish.jersey.process.internal.RequestScoped;
import si.fri.rso.projekt.prva.services.prvaBean;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@ApplicationScoped
@Path("prvaTest")
public class prvaApi {

    @Inject
    private prvaBean prvaBean;

    @GET
    @Produces("text/plain")
    public String hello() {
        return "Hello from kumuluze. its working!";
    }

    @GET
    @Path("discovery")
    public Response disc() {

        String returnMsg = prvaBean.getMessage();
        return Response.status(Response.Status.OK).entity(returnMsg).build();
    }
}
