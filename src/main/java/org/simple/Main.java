package org.simple;

import org.simple.annotation.InjectByType;
import org.simple.domain.Room;
import org.simple.factory.ObjectFactory;
import org.simple.service.AngryPoliceman;
import org.simple.service.Desinfector;
import org.simple.service.Policeman;
import org.simple.service.PolicemanImpl;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args){
//        Desinfector desinfector = ObjectFactory.getInstance().createObject(Desinfector.class);
        ApplicationContext run = Application.run("org.simple",
                new HashMap<>(Map.of(Policeman.class, PolicemanImpl.class)));
        Desinfector desinfector = run.getObject(Desinfector.class);
        desinfector.start(new Room());
    }
}
