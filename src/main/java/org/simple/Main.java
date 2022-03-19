package org.simple;

import org.simple.domain.Room;
import org.simple.service.Desinfector;

public class Main {

    public static void main(String[] args){
        new Desinfector().start(new Room());
    }
}
