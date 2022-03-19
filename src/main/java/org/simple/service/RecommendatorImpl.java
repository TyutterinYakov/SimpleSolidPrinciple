package org.simple.service;

public class RecommendatorImpl implements Recommendator{
    @InjectProperty
    private String alcohol;
    @Override
    public void recommend() {
        System.out.println(" to protect from virus. drink "+alcohol);
    }
}
