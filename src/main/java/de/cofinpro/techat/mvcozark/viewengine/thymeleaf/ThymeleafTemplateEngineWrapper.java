package de.cofinpro.techat.mvcozark.viewengine.thymeleaf;

import org.slf4j.Logger;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;
import org.thymeleaf.templateresolver.TemplateResolution;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.servlet.ServletContext;
import java.io.Writer;

/**
 * Da die TemplateEngine-Klasse nicht direkt injected werden kann (enthält finale Methoden), braucht es einen Wrapper.
 * Created by David Olah on 24.10.2017.
 */
@ApplicationScoped
public class ThymeleafTemplateEngineWrapper {
    @Inject
    private Logger logger;

    @Inject
    private ServletContext servletContext;

    private TemplateEngine templateEngine;

    @PostConstruct
    public void initialize() {
        logger.debug("Initializing ThymeleafTemplateEngineWrapper");
        ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver(servletContext);
        templateResolver.setPrefix("/views/");
        templateResolver.setSuffix(".th.html");
        templateResolver.setTemplateMode(TemplateMode.HTML);
        templateResolver.setCacheable(false);

        this.templateEngine = new TemplateEngine();
        this.templateEngine.setTemplateResolver(templateResolver);
    }

    public void process(String template, WebContext webContext, Writer writer) {
        logger.debug("Processing with ThymeleafTemplateEngineWrapper");
        templateEngine.process(template, webContext, writer);
    }
}
