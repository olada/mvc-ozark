package de.cofinpro.techat.mvcozark.sandbox.controller;

import de.cofinpro.techat.mvcozark.shared.annotation.RequestHeader;
import de.cofinpro.techat.mvcozark.shared.util.Utils;
import org.slf4j.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.mvc.View;
import javax.mvc.Viewable;
import javax.servlet.http.HttpSession;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/**
 * Dieser Controller zeigt alle Return-Types, wie Views gesteuert werden können:
 * - String
 * - void (mit @View-Annotation)
 * - Viewable (der eine @View-Annotation überschreibt)
 * - Response
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

    @Inject @RequestHeader("X-Cofinpro")
    private String cofinproHeader;

    @Inject
    private HttpSession session;

    @GET
    public String getDefault() {
        models.put("test", "helloWorld");
        return "/index/index.th.htm";
    }

    @GET
    @Path("/somethings")
    @View("/index/somethingOne.th.html")
    public void getSomething(@QueryParam("param") @DefaultValue("none") String param, @HeaderParam("X-Cofinpro") String cofinpro) {
        models.put("param", param);
        models.put("hello", cofinproHeader);
        logger.info("Models = {}", Utils.toString(models));
    }

    @GET
    @Path("/somethings2")
    @View("/does/not/exist/and/will/be/overridden")
    public Viewable getSomething2(@QueryParam("param") @DefaultValue("none") String param) {
        models.put("param", param);
        session.setAttribute("test", param);
        return new Viewable("/index/somethingOne.th.html", models);
    }

    @GET
    @Path("/somethings3")
    @View("does/not/exist/and/will/be/overridden")
    public Response getSomething3(@QueryParam("param") @DefaultValue("foobar") String param) {
        models.put("aabbcc", param);
        return Response.ok().header("X-Cofinpro-Office", "Frankfurt").entity("/index/somethingOne.th.html").build();
    }
}
