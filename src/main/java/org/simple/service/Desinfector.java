package org.simple.service;

import org.simple.annotation.InjectByType;
import org.simple.factory.ObjectFactory;
import org.simple.domain.Room;

public class Desinfector {

    @InjectByType
    private Announcer announcer;
    @InjectByType
    private Policeman policeman;

    public void start(Room room){

        announcer.announce("Начинаем дезинфекцию");
        policeman.makePeopleLeaveRoom();
        desinfect(room);
        announcer.announce("Можете вернуться в комнату");
    }

    private void desinfect(Room room){
        System.out.println("Очистка");
    }
}
