public class Battleground {
    int frontline;
    Army armyRed;
    Army armyBlue;
    RoundSequence sequence = new RoundSequence();


    Battleground(Army red, Army blue, int size) {
        frontline = size;
        armyRed = red;
        armyBlue = blue;
        armyRed.vanguard = new Vanguard(frontline);
        armyRed.updateVanguard(sequence);
        armyBlue.vanguard = new Vanguard(frontline);
        armyBlue.updateVanguard(sequence);
    }

    public void battle() {

        int counter = 1;


        while ((armyRed.armyPool.composition.size() > 0
                || armyRed.vanguard.composition.size() > 0)
                &&
                (armyBlue.armyPool.composition.size() > 0
                        || armyBlue.vanguard.composition.size() > 0)) {


            for (int i = 0; i < 5; i++) {
                for (Warrior warrior : sequence.order) {
                    if (!warrior.isDead) {
                        if (!warrior.nation.equals(armyRed.armyName)) {
                            warrior.attack(armyRed.vanguard);
                        } else {
                            warrior.attack(armyBlue.vanguard);
                        }
                    }
                }
            }
            System.out.println("ROUND FINISHED " + counter++);
            armyBlue.updateVanguard(sequence);
            armyRed.updateVanguard(sequence);
            int combatants = armyRed.armyPool.composition.size() +
                    armyRed.vanguard.composition.size() +
                    armyBlue.armyPool.composition.size() +
                    armyBlue.vanguard.composition.size();
            System.out.println("COMBATANTS LEFT: " + combatants);

        }
        if (armyRed.vanguard.composition.size() > armyBlue.vanguard.composition.size()) {
            System.out.println("WINNER IS " + armyRed.armyName);
        } else {
            System.out.println("WINNER IS " + armyBlue.armyName);
        }
    }
}



