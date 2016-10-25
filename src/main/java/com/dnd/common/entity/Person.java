package com.dnd.common.entity;

import java.util.Random;

/**
 * Created by Orlov on 09.10.2016.
 */

public class Person {
    final Random random = new Random();
    int strength;
    int dexterity;
    int constitution;
    String nation;
    boolean isNoble;

    Person() {
    }

    Person(String nation) {
        this.nation = nation;
        strength = random.nextInt(4)+1;
        dexterity = random.nextInt(4)+1;
        constitution = random.nextInt(4)+1;
        isNoble = random.nextBoolean();
    }

}