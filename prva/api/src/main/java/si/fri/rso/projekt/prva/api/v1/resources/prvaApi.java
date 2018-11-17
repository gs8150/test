package si.fri.rso.projekt.prva.api.v1.resources;

import si.fri.rso.projekt.prva.services.beans.prvaBean;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@RequestScoped
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

    @GET
    @Path("url")
    public Response test() {
        String response = prvaBean.getMessageDiscovery();
        return Response.status(Response.Status.OK).entity(response).build();

    }

    @GET
    @Path("service")
    public Response service() {
        return Response.status(Response.Status.OK).entity(prvaBean.readConfig()).build();
    }

    @GET
    @Path("disable")
    public Response test4() {
        prvaBean.setConfig(false);
        String response = "OK";
        return Response.status(Response.Status.OK).entity(response).build();
    }

    @GET
    @Path("enable")
    public Response test5() {
        prvaBean.setConfig(true);
        String response = "OK";
        return Response.status(Response.Status.OK).entity(response).build();
    }
}
