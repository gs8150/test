package si.fri.rso.projekt.druga.api.v1.resources;

import com.kumuluz.ee.discovery.annotations.DiscoverService;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("drugaTest")
public class drugaApi {

    @Inject
    @DiscoverService(value = "druga")
    private WebTarget target;

    @GET
    @Produces("text/plain")
    public String hello() {
        return "Hello from kumuluze. its working!";
    }

    @GET
    @Path("url")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getUrl() {
        return Response.ok(target.getUri().toString()).build();
    }
}
