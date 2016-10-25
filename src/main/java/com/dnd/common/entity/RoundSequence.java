package com.dnd.common.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Orlov on 13.10.2016.
 */
public class RoundSequence {

    List<Warrior> order = new ArrayList<Warrior>();

    void updateSequence(Warrior warrior) {

        for (int i = 0; i < order.size(); i++) {
            if (warrior.initiative > order.get(i).initiative) {
                order.add(i, warrior);
                return;
            }
        }
        order.add(warrior);
    }


    void printSequence() {
        System.out.println("Sequence");
        for (int i = 0; i < order.size(); i++) {
            System.out.println(order.get(i));
        }
    }
}
