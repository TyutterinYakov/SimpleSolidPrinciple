package org.simple.config;

import lombok.SneakyThrows;
import org.simple.ApplicationContext;
import org.simple.annotation.InjectProperty;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InjectPropertyAnnotationObjectConfigurator implements ObjectConfigurator{

    Map<String, String> propertiesMap;

    @SneakyThrows
    public InjectPropertyAnnotationObjectConfigurator() {
        String path = ClassLoader.getSystemClassLoader().getResource("application.properties").getPath();
        Stream<String> lines = new BufferedReader(new FileReader(path)).lines();
        this.propertiesMap = lines.map(line -> line.split("="))
                .collect(Collectors.toMap(arr -> arr[0], arr -> arr[1]));
    }

    @SneakyThrows
    @Override
    public void configure(Object obj, ApplicationContext context) {
        Class<?> implClass = obj.getClass();
        for (Field field : implClass.getDeclaredFields()) {
            InjectProperty annotation = field.getAnnotation(InjectProperty.class);
            if(annotation!=null){
                String value = (annotation.value().isEmpty())?
                        propertiesMap.get(field.getName()):
                        propertiesMap.get(annotation.value());
                field.setAccessible(true);
                field.set(obj, value);
            }

        }
    }
}
