package de.cofinpro.techat.mvcozark.techatplanner.controller;

import de.cofinpro.techat.mvcozark.techatplanner.beanparam.TechatEvent;
import de.cofinpro.techat.mvcozark.techatplanner.model.PossibleTopicsBean;
import org.slf4j.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.mvc.Models;
import javax.mvc.annotation.Controller;
import javax.mvc.annotation.View;
import javax.validation.Valid;
import javax.validation.executable.ExecutableType;
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
    private PossibleTopicsBean possibleTopicsBean;

    @GET
    @Path("/")
    @View("index/index.th.html")
    public void getIndex() {

    }

    @GET
    @Path("/jsp")
    @View("index/index.jsp")
    public void getIndexJsp() {
        logger.debug("TopicsMessage: {}", possibleTopicsBean.getTopicsMessage());
    }

    @POST
    @Path("/")
    @View("index/index.th.html")
    @ValidateOnExecution(type = ExecutableType.NONE)
    public void update(@Valid @BeanParam TechatEvent postedTechatEvent) {
        logger.info("Posted Form-Object: {}", postedTechatEvent);
        models.put("postedEvent", postedTechatEvent);
    }
}
