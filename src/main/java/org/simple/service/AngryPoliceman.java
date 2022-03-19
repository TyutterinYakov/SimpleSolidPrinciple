package org.simple.service;

public class AngryPoliceman implements Policeman{
    @Override
    public void makePeopleLeaveRoom() {
        System.out.println("Я злой! Все вон!  БАМ");
    }
}
