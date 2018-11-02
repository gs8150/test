package si.fri.rso.projekt.druga.api.v1.resources;

//import com.kumuluz.ee.discovery.annotations.DiscoverService;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.logging.Logger;

@Path("drugaTest")
public class drugaApi {

    private Logger log = Logger.getLogger(drugaApi.class.getName());

    //@Inject
    //private drugaApi customersBean;

    private Client httpClient;

    @PostConstruct
    private void init() {
        httpClient = ClientBuilder.newClient();
    }

    @GET
    @Produces("text/plain")
    public String hello() {
        return "Hello from kumuluze. its working!";
    }

    @GET
    @Path("url")
    @Produces("text/plain")
    public Response test() {
        try {

            httpClient
                    .target("http://localhost:8080/v1/prvaTest/discovery")
                    .request()
                    .get(new GenericType<String>(){});

            //kle manjka model za modul druga, ki dejansko poklice httpClient
            //ta fajl je pa kot api in samo vrne Response!
            return Response.status(Response.Status.OK).entity(httpClient).build();

        }
        catch (WebApplicationException | ProcessingException  e) {
            log.severe(e.getMessage());
            throw new InternalServerErrorException("neki še ni ok" + e.getMessage());
        }
    }
    /*
    public String test() {
        try {

            return httpClient
                    .target("http://localhost:8080/v1/prvaTest/discovery")
                    .request()
                    .get(new GenericType<String>(){});

        }
        catch (WebApplicationException | ProcessingException  e) {
            log.severe(e.getMessage());
            throw new InternalServerErrorException("neki še ni ok" + e.getMessage());
        }
    }*/

    @GET
    @Path("url2")
    @Produces("text/plain")
    public String test2() {
        return "dela!";

    }
}
