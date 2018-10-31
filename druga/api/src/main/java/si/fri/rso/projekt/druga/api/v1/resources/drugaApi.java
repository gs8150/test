package si.fri.rso.projekt.druga.api.v1.resources;

import com.kumuluz.ee.discovery.annotations.DiscoverService;
import org.glassfish.jersey.process.internal.RequestScoped;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RequestScoped
@Path("drugaTest")
public class drugaApi {

    @Inject
    @DiscoverService(value = "druga")
    private WebTarget target;

    @Inject
    @DiscoverService(value = "prva")
    private WebTarget target2;

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
