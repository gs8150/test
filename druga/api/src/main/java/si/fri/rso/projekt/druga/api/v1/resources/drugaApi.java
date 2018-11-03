package si.fri.rso.projekt.druga.api.v1.resources;

//import com.kumuluz.ee.discovery.annotations.DiscoverService;

import si.fri.rso.projekt.druga.services.drugaBean;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.logging.Logger;

@Path("drugaTest")
@RequestScoped
public class drugaApi {

    private Logger log = Logger.getLogger(drugaApi.class.getName());

    @Inject
    private drugaBean drugaBean;

    @GET
    @Produces("text/plain")
    public String hello() {
        return "Hello from kumuluze. its working!!!";
    }

    @GET
    @Path("url")
    public Response test() {
        String response = drugaBean.getMessage();
        return Response.status(Response.Status.OK).entity(response).build();
    }

    @GET
    @Path("url2")
    public Response test2() {
        String response = drugaBean.getMessage2();
        return Response.status(Response.Status.OK).entity(response).build();

    }

    @GET
    @Path("url3")
    public Response test22() {
        String response = drugaBean.getMessage22();
        return Response.status(Response.Status.OK).entity(response).build();

    }

    @GET
    @Path("service")
    public Response test3() {
        String response = drugaBean.readConfig();
        return Response.status(Response.Status.OK).entity(response).build();
    }

    @GET
    @Path("disable")
    public Response test4() {
        drugaBean.setConfig(false);
        String response = "OK";
        return Response.status(Response.Status.OK).entity(response).build();
    }

    @GET
    @Path("enable")
    public Response test5() {
        drugaBean.setConfig(true);
        String response = "OK";
        return Response.status(Response.Status.OK).entity(response).build();
    }
}