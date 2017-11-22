package de.cofinpro.techat.mvcozark.shared.producer;

import de.cofinpro.techat.mvcozark.shared.annotation.SessionAttribute;
import org.slf4j.Logger;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

/**
 * Created by David Olah on 24.10.2017.
 */
@Dependent
public class SessionAttributeProducer {
    @Inject
    private Logger logger;

    @Context
    private HttpServletRequest httpRequest;

    @Produces @SessionAttribute
    public Object getSessionAttribute(InjectionPoint injectionPoint) {
        logger.info("Producing session attribute..");
        String annotationValue = injectionPoint.getAnnotated().getAnnotation(SessionAttribute.class).value();
        HttpSession session = httpRequest.getSession();
        return session.getAttribute(annotationValue);
    }
}
