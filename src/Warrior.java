/**
 * Created by Orlov on 09.10.2016.
 */


abstract class Warrior extends Person implements Comparable<Warrior> {
    String type;
    int weaponAcc;
    int weaponDamage;
    int armorReduction;
    int attackMod;
    int damageMod;
    int defence;
    int initiativeMod;
    int health;
    int position;
    int initiative;
    boolean isDead;

    public int roll20() {
        return random.nextInt(20) + 1;
    }

    public Warrior attack(Vanguard enemyVanguard) {
        Warrior target = chooseTarget(enemyVanguard);
        if (target != null) {
            if (rollAttackDice(target)) {
                if (rollDamageDice(target)) {
                    return target;
                }
            }
        }
        return null;
    }

    public Warrior chooseTarget(Vanguard enemyVanguard) {
        for (int deviation = 0; deviation < enemyVanguard.composition.size(); deviation++) {
            if (position + deviation < enemyVanguard.composition.size()
                    && enemyVanguard.composition.get(position + deviation).isDead == false) {
                return enemyVanguard.composition.get(position + deviation);
            }
            if (position - deviation > 0
                    && position + deviation < enemyVanguard.composition.size()
                    && enemyVanguard.composition.get(position - deviation).isDead == false) {
                return enemyVanguard.composition.get(position - deviation);
            }
        }
        return null;
    }

    public boolean rollAttackDice(Warrior enemy) {
        int attackRoll = roll20() + attackMod;
        boolean isHit = attackRoll > enemy.defence;
        return isHit;
    }

    public boolean rollDamageDice(Warrior enemy) {
        //TODO DAMAGE ZERO CHECK

        int damageRoll = roll20() + damageMod - enemy.armorReduction;
        enemy.health = enemy.health - damageRoll;
        if (enemy.health < 1) {
            enemy.isDead = true;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int compareTo(Warrior warrior) {
        return Integer.compare(initiative, warrior.initiative);
    }

    public void rollInitiative() {
        if (initiative == 0) {
            initiative = roll20() + initiativeMod;
        }
    }

    @Override
    public String toString() {
        return "Nat:" + nation + "/Cls:" + type + "/Init:" + initiative + "/Pos:" + position;
    }

}

class Rogue extends Warrior {

    public Rogue(Person recruit) {
        this.nation = recruit.nation;
        type = "Rogue";
        weaponAcc = +7;
        weaponDamage = +0;
        armorReduction = 0;
        attackMod = recruit.dexterity + weaponAcc;
        damageMod = recruit.dexterity * 2 + weaponDamage;
        defence = 10 + recruit.dexterity;
        initiativeMod = recruit.dexterity;
        health = random.nextInt(8) + recruit.constitution + 1;
    }
}

class Knight extends Warrior {

    public Knight(Person recruit) {
        this.nation = recruit.nation;
        type = "Knight";
        weaponAcc = +5;
        weaponDamage = +1;
        armorReduction = 2;
        attackMod = recruit.strength + weaponAcc;
        damageMod = recruit.strength * 2 + weaponDamage;
        defence = 10 + recruit.dexterity;
        initiativeMod = recruit.dexterity;
        health = random.nextInt(10) + recruit.constitution + 1;
    }

}

class Pikeman extends Warrior {

    public Pikeman(Person recruit) {
        this.nation = recruit.nation;
        type = "Pikeman";
        weaponAcc = +6;
        weaponDamage = +1;
        armorReduction = 1;
        attackMod = recruit.strength + weaponAcc;
        damageMod = recruit.strength + weaponDamage;
        defence = 10 + recruit.dexterity;
        initiativeMod = recruit.dexterity;
        health = random.nextInt(10) + recruit.constitution + 1;
    }
}



