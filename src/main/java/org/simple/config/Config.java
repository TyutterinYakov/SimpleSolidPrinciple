package org.simple.config;

public interface Config {
    <T> Class<? extends T> getImplClass(Class<T> type);
}
