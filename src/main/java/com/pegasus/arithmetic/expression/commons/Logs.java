package com.pegasus.arithmetic.expression.commons;

import org.apache.log4j.Logger;

public class Logs {

    private final static Logger APP_LOGGER = Logger.getLogger("app");

    public static Logger getAppLoggers() {
        return APP_LOGGER;
    }

}
