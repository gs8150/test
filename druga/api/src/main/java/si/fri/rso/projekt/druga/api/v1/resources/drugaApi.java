package si.fri.rso.projekt.druga.api.v1.resources;

import javax.ws.rs.*;

@Path("drugaTest")
public class drugaApi {
    @GET
    @Produces("text/plain")
    public String hello() {
        return "Hello from kumuluze. its working!";
    }
}
