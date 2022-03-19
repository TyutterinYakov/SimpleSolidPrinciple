package org.simple.factory;

import lombok.Setter;
import lombok.SneakyThrows;
import org.simple.ApplicationContext;
import org.simple.config.Config;
import org.simple.config.JavaConfig;
import org.simple.config.ObjectConfigurator;
import org.simple.service.AngryPoliceman;
import org.simple.service.Policeman;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ObjectFactory {
    private List<ObjectConfigurator> configurators = new ArrayList<>();
    private final ApplicationContext context;

    @SneakyThrows
    public ObjectFactory(ApplicationContext context) {
        this.context = context;
        for (Class<? extends ObjectConfigurator> aClass : context.getConfig().getScanner().getSubTypesOf(ObjectConfigurator.class)) {
            configurators.add(aClass.getDeclaredConstructor().newInstance());
        }
    }

    @SneakyThrows
    public <T> T createObject(Class<T> implClass){


        T t = implClass.getDeclaredConstructor().newInstance();

        configurators.forEach(objConf -> objConf.configure(t, context));
        return t;
    }
}
