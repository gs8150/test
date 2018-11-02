package si.fri.rso.projekt.druga.services;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.ProcessingException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import java.util.logging.Logger;


@ApplicationScoped
public class drugaBean {

    private Client httpClient;

    private Logger log = Logger.getLogger(drugaBean.class.getName());

    @PostConstruct
    private void init() {
        httpClient = ClientBuilder.newClient();
    }

    public String getMessage() {
        try {

            /*return httpClient
                    .target("http://localhost:8080/v1/prvaTest/discovery")
                    .request()
                    .get(String.class);*/
            return httpClient
                    .target("http://192.168.1.135:8080/v1/prvaTest/discovery")
                    .request()
                    .get(String.class);
        }
        catch (WebApplicationException | ProcessingException e) {
            //throw new InternalServerErrorException(e.getMessage());
            return e.getMessage();
        }
    }

    public String getMessage2() {
        return "Hello from module DRUGA!";
    }
}
