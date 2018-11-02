package si.fri.rso.projekt.druga.api.v1.resources;

//import com.kumuluz.ee.discovery.annotations.DiscoverService;

import si.fri.rso.projekt.druga.services.drugaBean;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.logging.Logger;

@Path("drugaTest")
public class drugaApi {

    private Logger log = Logger.getLogger(drugaApi.class.getName());


    @Inject
    private drugaBean drugaBean;


    @GET
    @Produces("text/plain")
    public String hello() {
        return "Hello from kumuluze. its working!";
    }

    @GET
    @Path("url")
    @Produces("text/plain")
    public Response test() {
        String response = drugaBean.getMessage();
        return Response.status(Response.Status.OK).entity(response).build();
    }

    @GET
    @Path("url2")
    @Produces("text/plain")
    public String test2() {
        return "dela!";

    }
}
