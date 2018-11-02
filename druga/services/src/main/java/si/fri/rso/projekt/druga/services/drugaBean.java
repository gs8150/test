package si.fri.rso.projekt.druga.services;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.ProcessingException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

@RequestScoped
public class drugaBean {

    private Client httpClient;

    @PostConstruct
    private void init() {
        httpClient = ClientBuilder.newClient();
    }

    public String getMessage() {
        try {

            return httpClient
                    .target("http://localhost:8080/v1/prvaTest/discovery")
                    .request()
                    .get(String.class);
        }
        catch (WebApplicationException | ProcessingException e) {
            throw new InternalServerErrorException(e.getMessage());
        }
    }
}
