package de.cofinpro.techat.mvcozark.shared.util;

import javax.mvc.Models;

/**
 * Created by David Olah on 23.10.2017.
 */
public class Utils {
    public static String toString(Models models) {
        String str = "Models{";
        for (String key : models.keySet()) {
            str += key + " = " + models.get(key) + ", ";
        }
        str += "}";
        return str;
    }
}
