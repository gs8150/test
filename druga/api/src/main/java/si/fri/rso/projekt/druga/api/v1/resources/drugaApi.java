package si.fri.rso.projekt.druga.api.v1.resources;

//import com.kumuluz.ee.discovery.annotations.DiscoverService;
import org.glassfish.jersey.process.internal.RequestScoped;
import si.fri.rso.projekt.druga.api.v1.drugaApplication;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.ws.rs.*;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;


@RequestScoped
@Path("drugaTest")
public class drugaApi {

    private Client httpClient;

    @PostConstruct
    private void init() {
        httpClient = ClientBuilder.newClient();
    }

    si.fri.rso.projekt.druga.api.v1.drugaApplication drugaApplication;

    @GET
    @Produces("text/plain")
    public String hello() {
        return "Hello from kumuluze. its working!";
    }

    @GET
    @Path("url")
    @Produces("text/plain")
    public String test() {
        try {
            //return httpClient
            //        .target("http://localhost:8080/v1/prvaTest/discovery")
            //        .request().get(new GenericType<String>(){});
            /*return httpClient
                    .target("http://localhost:8080/v1/prvaTest")
                    .path("discovery")
                    .request(MediaType.TEXT_PLAIN)
                    .get(new GenericType<String>() {

                    });  //vrne org.glassfish.jersey.client.JerseyInvocation$Builder@2c3d48c7   */

            return httpClient
                    .target("http://localhost:8080/v1/prvaTest/discovery")
                    .request()
                    .get(String.class);
        }
        catch (WebApplicationException | ProcessingException e) {
            //return
            return "neki še ni ok!!!";
            //throw new InternalServerErrorException(e);
        }
    }

    @GET
    @Path("url2")
    public String test2() {
        return "dela!";

    }
}
