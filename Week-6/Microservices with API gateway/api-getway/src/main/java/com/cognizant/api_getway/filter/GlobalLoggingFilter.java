package com.cognizant.api_getway.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.function.HandlerFilterFunction;
import org.springframework.web.servlet.function.ServerResponse;

@Component
public class GlobalLoggingFilter {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(GlobalLoggingFilter.class);

    public void logRequest(String method, String uri) {
        LOGGER.info("Incoming Request -> {} {}", method, uri);
    }
}