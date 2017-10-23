package de.cofinpro.techat.mvcozark.viewengine.thymeleaf;

import org.slf4j.Logger;
import org.thymeleaf.context.WebContext;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.mvc.Models;
import javax.mvc.engine.ViewEngine;
import javax.mvc.engine.ViewEngineContext;
import javax.mvc.engine.ViewEngineException;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Locale;

/**
 * Created by David Olah on 23.10.2017.
 */
@ApplicationScoped
public class ThymeleafViewEngine implements ViewEngine  {
    @Inject
    private ThymeleafTemplateEngineWrapper templateEngineWrapper;

    @Inject
    private ServletContext servletContext;

    @Inject
    private Models models;

    @Inject
    private Logger logger;

    public boolean supports(String s) {
        logger.debug("Checking if ThymeleafViewEngine supprts the template {}", s);
        //return s.contains(".th");
        return true;
    }

    public void processView(ViewEngineContext viewEngineContext) throws ViewEngineException {
        logger.debug("Attempting to process view with ThyleafViewEngine");
        try {
            HttpServletRequest request = viewEngineContext.getRequest();
            HttpServletResponse response = viewEngineContext.getResponse();
            WebContext webContext = new WebContext(request, response, servletContext, request.getLocale());
            webContext.setVariables(viewEngineContext.getModels());
            templateEngineWrapper.process(viewEngineContext.getView(), webContext, response.getWriter());
        } catch (IOException e) {
            throw new ViewEngineException(e);
        }
    }
}
