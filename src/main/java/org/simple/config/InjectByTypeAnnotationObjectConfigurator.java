package org.simple.config;

import lombok.SneakyThrows;
import org.simple.ApplicationContext;
import org.simple.annotation.InjectByType;
import org.simple.factory.ObjectFactory;

import java.lang.reflect.Field;

public class InjectByTypeAnnotationObjectConfigurator implements ObjectConfigurator{
    @Override
    @SneakyThrows
    public void configure(Object obj, ApplicationContext context) {
        for (Field field : obj.getClass().getDeclaredFields()) {
            if(field.isAnnotationPresent(InjectByType.class)){
                field.setAccessible(true);
                Object object = context.getObject(field.getType());
                field.set(obj, object);
            }
        }
    }
}
