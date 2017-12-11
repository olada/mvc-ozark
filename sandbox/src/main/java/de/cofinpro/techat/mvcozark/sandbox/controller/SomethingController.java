package de.cofinpro.techat.mvcozark.sandbox.controller;

import javax.mvc.annotation.Controller;
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
        return "/something/index.th.htm";
    }

    @Path("one")
    @GET
    public String getOne() {
        return "/something/one.th.htm";
    }

    @Path("two")
    @GET
    public String getTwo() {
        return "/something/two.th.htm";
    }
}
