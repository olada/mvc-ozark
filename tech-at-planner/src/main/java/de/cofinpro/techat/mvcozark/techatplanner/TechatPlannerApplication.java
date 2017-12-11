package de.cofinpro.techat.mvcozark.techatplanner;

import de.cofinpro.techat.mvcozark.techatplanner.controller.IndexController;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by David Olah on 22.11.2017.
 */
@ApplicationPath("/")
public class TechatPlannerApplication extends Application {
    @Override
    public Map<String, Object> getProperties() {
        Map<String, Object> props = new HashMap<>();

        // https://github.com/jersey/jersey/issues/3659
        props.put("jersey.config.beanValidation.disable.validateOnExecutableCheck.server", true);

        return props;
    }

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> set = new HashSet<>();
        set.add(IndexController.class);
        return set;
    }
}
