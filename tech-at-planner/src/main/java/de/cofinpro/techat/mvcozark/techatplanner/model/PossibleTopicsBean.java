package de.cofinpro.techat.mvcozark.techatplanner.model;

import org.slf4j.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by David Olah on 25.11.2017.
 */
@Named("possibleTopics")
@ApplicationScoped
public class PossibleTopicsBean {
    @Inject
    private Logger logger;
    private String topicsMessage;

    @PostConstruct
    public void initialize() {
        logger.debug("Initializing topics..");
        this.topicsMessage = "GraphQL, neo4J als Graph-DB, Impressionen aus dem DevOps-Alltag in VV";
    }

    public String getTopicsMessage() {
        return topicsMessage;
    }

    public void setTopicsMessage(String topicsMessage) {
        this.topicsMessage = topicsMessage;
    }
}
