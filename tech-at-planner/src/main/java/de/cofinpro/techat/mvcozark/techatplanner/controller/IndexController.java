package de.cofinpro.techat.mvcozark.techatplanner.controller;

import de.cofinpro.techat.mvcozark.techatplanner.beanparam.TechatEvent;
import org.slf4j.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.mvc.View;
import javax.mvc.validation.ValidationResult;
import javax.validation.Valid;
import javax.validation.executable.ValidateOnExecution;
import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 * Created by David Olah on 22.11.2017.
 */
@Path("/")
@Controller
@RequestScoped
public class IndexController {
    @Inject
    private Logger logger;

    @Inject
    private Models models;

    @Inject
    private ValidationResult validationResult;

    @GET
    @Path("/")
    @View("index/index.th.html")
    public void getIndex() {

    }

    @POST
    @Path("/")
    @View("index/index.th.html")
    public void update(@Valid @BeanParam TechatEvent postedTechatEvent) {
        logger.info("Posted Form-Object: {}", postedTechatEvent);
        logger.info("ValidationResult: {}", validationResult);
        models.put("postedEvent", postedTechatEvent);
        models.put("isValid", !validationResult.isFailed());
        if (validationResult.isFailed()) {
            models.put("violations", validationResult.getAllViolations());
        }
    }
}
