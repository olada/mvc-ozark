package de.cofinpro.techat.mvcozark.shared.producer;

import de.cofinpro.techat.mvcozark.shared.annotation.RequestHeader;
import org.slf4j.Logger;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;

/**
 * Created by David Olah on 24.10.2017.
 */
@Dependent
public class RequestHeaderProducer {
    @Inject
    private Logger logger;

    @Context
    private HttpServletRequest httpServletRequest;

    @Produces @RequestHeader
    public String getRequestHeader(InjectionPoint injectionPoint) {
        String annotationValue = injectionPoint.getAnnotated().getAnnotation(RequestHeader.class).value();
        return httpServletRequest.getHeader(annotationValue);
    }
}
