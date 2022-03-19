package org.simple.service;

import org.simple.config.ObjectFactory;
import org.simple.domain.Room;

public class Desinfector {

    private Announcer announcer = ObjectFactory.getInstance().createObject(Announcer.class);
    private Policeman policeman = ObjectFactory.getInstance().createObject(Policeman.class);

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
