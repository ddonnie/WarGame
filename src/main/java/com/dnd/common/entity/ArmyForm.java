package com.dnd.common.entity;

/**
 * Created by Orlov on 28.10.2016.
 */
public class ArmyForm {
    private int armySizeRight = 0;
    private int armySizeLeft = 0;
    private String armyNameRight = "Orks";
    private String armyNameLeft = "Elves";

    public int getArmySizeRight() {
        return armySizeRight;
    }

    public void setArmySizeRight(int armySizeRight) {
        this.armySizeRight = armySizeRight;
    }

    public int getArmySizeLeft() {
        return armySizeLeft;
    }

    public void setArmySizeLeft(int armySizeLeft) {
        this.armySizeLeft = armySizeLeft;
    }

    public String getArmyNameRight() {
        return armyNameRight;
    }

    public void setArmyNameRight(String armyNameRight) {
        this.armyNameRight = armyNameRight;
    }

    public String getArmyNameLeft() {
        return armyNameLeft;
    }

    public void setArmyNameLeft(String armyNameLeft) {
        this.armyNameLeft = armyNameLeft;
    }
}
