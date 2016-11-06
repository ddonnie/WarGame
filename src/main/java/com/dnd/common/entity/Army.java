package com.dnd.common.entity;

/**
 * Created by Orlov on 11.10.2016.
 */
public class Army {

    private int armySize;
    private String armyName;
    TrainingCamp trainingCamp = new TrainingCamp();
    Troop armyPool = new Troop();
    Vanguard vanguard;


    public int getArmySize() {
        return armySize;
    }

    public void setArmySize(int armySize) {
        this.armySize = armySize;
    }

    public String getArmyName() {
        return armyName;
    }

    public void setArmyName(String armyName) {
        this.armyName = armyName;
    }

    public void fillArmy() {
        for (int i = 0; i < armySize; i++) {
            armyPool.composition.add(trainingCamp.trainWarrior(armyName));
        }
    }

    void updateVanguard(RoundSequence sequence) {


        for (int i = 0; i < vanguard.frontline && armyPool.composition.size() > 0; i++) {


            if (notFilledUp(i)) {
                Warrior tempWarrior = getNewVanguardWarriorFromArmy(i);
                vanguard.addWarrior(tempWarrior);
                sequence.updateSequence(tempWarrior);

            }
            if (vanguardWarriorIsDead(i)) {
                Warrior tempWarrior = getNewVanguardWarriorFromArmy(i);
                vanguard.replaceWarrior(tempWarrior);
                sequence.updateSequence(tempWarrior);

            }
        }

        if (armyPool.composition.size() == 0) {
            for (Warrior warrior : sequence.order) {
                if (warrior.isDead) {
                    vanguard.composition.remove(warrior);
                }
            }
        }
    }

    private boolean vanguardWarriorIsDead(int i) {
        return vanguard.composition.get(i).isDead;
    }

    private boolean notFilledUp(int i) {
        return i > vanguard.composition.size() - 1;
    }


    private Warrior getNewVanguardWarriorFromArmy(int i) {
        Warrior tempWarrior = armyPool.composition.remove(armyPool.composition.size() - 1);
        tempWarrior.rollInitiative();
        tempWarrior.position = i;
        return tempWarrior;
    }

    void printArmy() {
        for (int i = 0; i < armyPool.composition.size(); i++) {
            System.out.println(armyPool.composition.get(i));
        }
    }

    void printVanguard() {
        for (int i = 0; i < vanguard.composition.size(); i++) {
            System.out.println(vanguard.composition.get(i));
        }
        System.out.println(vanguard.composition.size());
    }


}
