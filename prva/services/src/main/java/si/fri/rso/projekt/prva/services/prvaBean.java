package si.fri.rso.projekt.prva.services;

import javax.enterprise.context.ApplicationScoped;
import java.util.logging.Logger;

@ApplicationScoped
public class prvaBean {

    private Logger log = Logger.getLogger(prvaBean.class.getName());

    public String getMessage() {
        return "Hello from module PRVA!";
    }
}
