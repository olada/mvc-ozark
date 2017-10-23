package de.cofinpro.techat.mvcozark.controller;

import de.cofinpro.techat.mvcozark.util.Utils;
import de.cofinpro.techat.mvcozark.viewengine.thymeleaf.ThymeleafViewEngine;
import org.slf4j.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.mvc.Viewable;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

/**
 * Created by David Olah on 22.10.2017.
 */
@Controller
@Path("/")
@RequestScoped
public class IndexController {
    @Inject
    private Models models;

    @Inject
    private Logger logger;

    @GET
    public String getDefault() {
        models.put("test", "helloWorld");
        return "/index/index.htm";
    }

    @GET
    @Path("/somethings")
    public String getSomething(@QueryParam("param") @DefaultValue("none") String param) {
        models.put("param", param);
        models.put("aabbcc", param);
        models.put("hello", "world");
        logger.info("Models = {}", Utils.toString(models));
        return "index/somethingOne";
    }

    @GET
    @Path("/somethings2")
    public Viewable getSomething2(@QueryParam("param") @DefaultValue("none") String param) {
        models.put("param", param);
        return new Viewable("/index/somethingOne.th.html", models, ThymeleafViewEngine.class);
    }
}
