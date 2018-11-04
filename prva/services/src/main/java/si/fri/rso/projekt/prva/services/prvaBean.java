package si.fri.rso.projekt.prva.services;

import com.kumuluz.ee.discovery.annotations.DiscoverService;
import si.fri.rso.projekt.prva.services.configuration.AppProperties;

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
public class prvaBean {

    private Logger log = Logger.getLogger(prvaBean.class.getName());

    private Client httpClient;

    @Inject
    private AppProperties appProperties;

    @Inject
    @DiscoverService(value = "rso-druga", version = "1.0.0", environment = "dev")
    private Optional<String> baseUrl;

    @PostConstruct
    private void init() {
        httpClient = ClientBuilder.newClient();
    }

    public String getMessage() {
        return "Hello from module PRVA!";
    }

    public String readConfig() {
        if(appProperties.isExternalServicesEnabled())
            return "ext service enabled!";
        return "ext service disabled";
    }

    public void setConfig(boolean config) {
        appProperties.setExternalServicesEnabled(config);
    }

    public String getMessageDiscovery(){
        if(baseUrl.isPresent()) {
            try {
                return httpClient
                        .target(baseUrl.get() + "/v1/drugaTest/url2")
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
}
