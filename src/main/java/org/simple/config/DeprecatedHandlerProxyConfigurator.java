package org.simple.config;

import lombok.SneakyThrows;
import net.sf.cglib.proxy.Enhancer;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DeprecatedHandlerProxyConfigurator implements ProxyConfigurator{

    @Override
    @SneakyThrows
    public Object replaceWithProxyIfNeeded(Object t, Class implClass) {
        if (implClass.isAnnotationPresent(Deprecated.class)) {

            if(implClass.getInterfaces().length==0){
                return Enhancer.create(implClass, new net.sf.cglib.proxy.InvocationHandler() {
                    @Override
                    public Object invoke(Object o, Method method, Object[] args) throws Throwable {
                        return getInvocationHandlerLogic(method, t, args);
                    }
                });
            }

            return Proxy.newProxyInstance(implClass.getClassLoader(), implClass.getInterfaces(), new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    return getInvocationHandlerLogic(method, t, args);
                }
            });
        } else {
            return t;
        }
    }

    private Object getInvocationHandlerLogic(Method method, Object t, Object[] args) throws IllegalAccessException, InvocationTargetException {
        System.out.println("********** DEPRECATED!!!");
        return method.invoke(t, args);
    }
}
