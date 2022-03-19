package org.simple.config;

import org.simple.ApplicationContext;

public interface ObjectConfigurator {
    void configure(Object obj, ApplicationContext context);
}
