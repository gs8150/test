package si.fri.rso.projekt.prva.services;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import java.util.logging.Logger;

@ApplicationScoped
@Dependent
public class prvaBean {

    private Logger log = Logger.getLogger(prvaBean.class.getName());

    public String getMessage() {
        return "Hello from module PRVA!";
    }
}
