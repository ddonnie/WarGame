/**
 * Created by Orlov on 13.10.2016.
 */
public class Vanguard extends Detachment {

    int frontline;

    Vanguard(int frontline) {
        this.frontline = frontline;
    }

    public void addWarrior(Warrior warrior) {
        composition.add(warrior);

    }

    public void replaceWarrior(Warrior warrior) {
        int position = warrior.position;
        composition.set(position, warrior);
    }

}
