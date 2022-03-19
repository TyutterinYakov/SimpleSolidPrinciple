package org.simple.service;

import org.simple.annotation.InjectByType;
import org.simple.factory.ObjectFactory;

public class ConsoleAnnouncer implements Announcer {
    @InjectByType
    private Recommendator recommendator;

    @Override
    public void announce(String message) {
        System.out.println(message);
        recommendator.recommend();
    }
}
