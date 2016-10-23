/**
 * Created by Orlov on 09.10.2016.
 */

public class TrainingCamp {

    private Person recruit;

    private Person createPerson(String nation) {
        return new Person(nation);
    }

    Warrior trainWarrior(String nation) {
        recruit = createPerson(nation);
        if (recruit.isNoble) {
            return trainKnight();
        } else if (recruit.strength >= recruit.dexterity) {
            return trainPikeman();
        } else {
            return trainRogue();
        }
    }

    private Knight trainKnight() {
        return new Knight(recruit);
    }

    private Pikeman trainPikeman() {
        return new Pikeman(recruit);
    }

    private Rogue trainRogue() {
        return new Rogue(recruit);
    }





}
