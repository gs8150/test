package si.fri.rso.projekt.prva.api.v1.resources;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

//@RequestScoped
@Path("prva")
public class prvaApi {
    @GET
    @Produces("text/plain")
    public String hello() {
        return "Hello from kumuluze. its working but when running jar on host computer inside cmd enviroment using this command: java -jar customers-api-1.0.0-SNAPSHOT.jar";
    }
}
