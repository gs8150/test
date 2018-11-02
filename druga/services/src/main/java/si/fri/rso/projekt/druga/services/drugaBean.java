package si.fri.rso.projekt.druga.services;

import com.kumuluz.ee.discovery.annotations.DiscoverService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.ProcessingException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import java.util.Optional;
import java.util.logging.Logger;


@ApplicationScoped
public class drugaBean {

    private Client httpClient;

    private Logger log = Logger.getLogger(drugaBean.class.getName());

    @Inject
    @DiscoverService("rso-prva")
    //private String baseUrl;
    private Optional<String> baseUrl;

    @PostConstruct
    private void init() {
        httpClient = ClientBuilder.newClient();
    }

    public String getMessage() {
        if(baseUrl.isPresent()) {
            try {

                /*return httpClient
                        .target("http://localhost:8080/v1/prvaTest/discovery")
                        .request()
                        .get(String.class);*/
                /*return httpClient
                        .target("http://192.168.1.135:8080/v1/prvaTest/discovery")
                        .request()
                        .get(String.class);*/
               return httpClient
                        .target(baseUrl + "/v1/prvaTest/discovery")
                        .request()
                        .get(String.class);
            }
            catch (WebApplicationException | ProcessingException e) {
                //throw new InternalServerErrorException(e.getMessage());
                return e.getMessage();
            }
        }


        return "baseUrl is not present!";
    }

    public String getMessage2() {
        return "Hello from module DRUGA !";
    }
}
