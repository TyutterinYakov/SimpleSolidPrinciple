package org.simple.service;

import org.simple.annotation.InjectProperty;
import org.simple.annotation.Singletone;

@Singletone
@Deprecated
public class RecommendatorImpl implements Recommendator{
    @InjectProperty
    private String alcohol;

    public RecommendatorImpl() {
        System.out.println("Recomendator was created");
    }

    @Override
    public void recommend() {
        System.out.println(" to protect from virus. drink "+alcohol);
    }
}
