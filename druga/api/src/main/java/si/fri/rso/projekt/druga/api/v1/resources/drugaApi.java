package si.fri.rso.projekt.druga.api.v1.resources;

//import com.kumuluz.ee.discovery.annotations.DiscoverService;
import org.glassfish.jersey.process.internal.RequestScoped;

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
            return httpClient
                    .target("http://localhost:8080/v1/prvaTest/discovery")
                    .request(MediaType.TEXT_PLAIN)
                    .get().toString();  //vrne org.glassfish.jersey.client.JerseyInvocation$Builder@2c3d48c7
        }
        catch (WebApplicationException | ProcessingException e) {
            //return
            return "neki še ni ok!!!";
            //throw new InternalServerErrorException(e);
        }
    }

    @GET
    @Path("url2")
    @Produces("text/plain")
    public String test2() {
        return "dela!";

    }
}
