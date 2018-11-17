package si.fri.rso.projekt.druga.services.beans;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kumuluz.ee.discovery.annotations.DiscoverService;
import si.fri.rso.projekt.druga.services.configuration.AppProperties;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.ProcessingException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import java.util.Optional;
import java.util.logging.Logger;


//@ApplicationScoped
@RequestScoped
public class drugaBean {

    private Logger log = Logger.getLogger(drugaBean.class.getName());

    @Inject
    private AppProperties appProperties;

    private Client httpClient;

    private ObjectMapper objectMapper;

    @Inject
    @DiscoverService("rso-prva")
    //private String baseUrl;
    private Optional<WebTarget> baseurl;

    @PostConstruct
    private void init() {
        httpClient = ClientBuilder.newClient();
        objectMapper = new ObjectMapper();
    }

    public String getMessage() {
        System.out.println(baseurl.toString());


        if(baseurl.isPresent()) {
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
                        .target(baseurl.get() + "/v1/prvaTest/discovery")
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

    public String getMessage22() {
            try {

                return httpClient
                        .target("http://192.168.1.135:8081/v1/prvaTest/discovery")
                        .request()
                        .get(String.class);
            }
            catch (WebApplicationException | ProcessingException e) {
                //throw new InternalServerErrorException(e.getMessage());
                return e.getMessage();
            }
    }

    public String getMessage2() {
        return "Hello from module DRUGA !";
    }

    public String readConfig() {
        if(appProperties.isExternalServicesEnabled())
            return "ext service enabled!";
        return "ext service disabled";
    }

    public void setConfig(boolean config) {
        appProperties.setExternalServicesEnabled(config);
    }

    public void setIp(String ip) {
        appProperties.setIpAddress(ip);
    }

    public String getIp() {
        return appProperties.getIpAddress();
    }
}
