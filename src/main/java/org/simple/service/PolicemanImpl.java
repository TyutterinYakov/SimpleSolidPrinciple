package org.simple.service;

import org.simple.annotation.InjectByType;
import org.simple.service.Policeman;

public class PolicemanImpl implements Policeman {

    @InjectByType
    private Recommendator recommendator;

    @Override
    public void makePeopleLeaveRoom() {
        System.out.println(recommendator.getClass());
        System.out.println("Пиф паф, бах бах, кыш, кыш");
    }
}
