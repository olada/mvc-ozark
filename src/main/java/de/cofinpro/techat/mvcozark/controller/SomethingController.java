package de.cofinpro.techat.mvcozark.controller;

import javax.mvc.Controller;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * Created by David Olah on 23.10.2017.
 */
@Controller
@Path("/something")
public class SomethingController {
    @GET
    public String getDefault() {
        return "/something/index.htm";
    }

    @Path("one")
    @GET
    public String getOne() {
        return "/something/one.htm";
    }

    @Path("two")
    @GET
    public String getTwo() {
        return "/something/two.htm";
    }
}
