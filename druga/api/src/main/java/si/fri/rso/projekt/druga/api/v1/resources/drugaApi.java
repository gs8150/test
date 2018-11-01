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
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Optional;

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

            //return httpClient
            //        .target("http://localhost:8080/v1/prvaTest/discovery")
            //        .request(MediaType.TEXT_PLAIN)
            //        .get(String.class);

            URL myurl = new URL("http://localhost:8080/v1/prvaTest");
            HttpURLConnection con = (HttpURLConnection) myurl.openConnection();

            con.setRequestMethod("GET");

            StringBuilder content = new StringBuilder();
            content.append("What I Get: ");

            try (BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()))) {

                String line;
                content = new StringBuilder();

                while ((line = in.readLine()) != null) {
                    content.append(line);
                    content.append(System.lineSeparator());
                }


            } catch (IOException e) {
                throw new InternalServerErrorException(e.getMessage());
            }

            return content.toString();

        }
        //catch (WebApplicationException | ProcessingException  | Exception e) {
        catch (Exception e) {
            //return
            //return "neki še ni ok!!!";
            throw new InternalServerErrorException(e.getMessage());
        }
    }

    @GET
    @Path("url2")
    @Produces("text/plain")
    public String test2() {
        return "dela!";

    }
}
