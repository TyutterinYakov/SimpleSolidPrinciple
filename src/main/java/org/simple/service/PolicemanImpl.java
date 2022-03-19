package org.simple.service;

import lombok.extern.slf4j.Slf4j;
import org.simple.annotation.InjectByType;
import org.simple.service.Policeman;

import javax.annotation.PostConstruct;

@Slf4j
public class PolicemanImpl implements Policeman {

    @InjectByType
    private Recommendator recommendator;

    @PostConstruct
    public void init() {
       log.info(String.valueOf(recommendator.getClass()));
    }

    @Override
    public void makePeopleLeaveRoom() {
        System.out.println(recommendator.getClass());
        System.out.println("Пиф паф, бах бах, кыш, кыш");
    }
}
