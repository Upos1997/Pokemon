package src.moves.moveLogic;

import java.util.List;

import src.combat.action.MoveAction;
import src.combat.action.MoveActionSingle;
import src.combat.field.Field;
import src.combat.field.Slot;
import src.pokemon.Pokemon;
import src.pokemon.Type;

public abstract class Move {

    static protected List<Type> types;
    static protected Targeting target = Targeting.ADJACENT;
    static protected double accuracy = 1;
    static protected int ppMax;
    static protected int ppCurrent = ppMax;
    static protected int priority = 0;

    public List<Type> getTypes() {
        return types;
    }
    public List<Slot> getTargets(Field field, Pokemon user) {
        return target.getTargets(field, user);
    }
    public double getAccuracy() {
        return accuracy;
    }
    public int getPriority() {
        return priority;
    }
    public void recharge() {
        ppCurrent = ppMax;
    }

    static protected double critChance = 1/24f;
    static protected double critDamage = 1.5;
    static protected double stab = 1.5;

    public double getCritChance() {
        return critChance;
    }

    public double getCritDamage() {
        return critDamage;
    }

    public double getStab() {
        return stab;
    }

    abstract public boolean use(Field field, Pokemon user);
    abstract public boolean singleTarget(Field field, MoveActionSingle action);

    abstract public Move getInstance();

    public boolean makesContact() {
        return false;
    }

    public boolean isAutoHit() {
        return false;
    }

    public boolean isAutoCrit() {
        return false;
    }

    public boolean isStatus() {
        return false;
    }

    public boolean isPhysical() {
        return false;
    }

    public boolean isSpecial() {
        return false;
    }

    public boolean isSound() {
        return false;
    }

    public boolean isBullet() {
        return false;
    }

    public boolean isPowder() {
        return false;
    }

    public boolean isPunch() {
        return false;
    }

    public boolean isBite() {
        return false;
    }

    public boolean isSlicing() {
        return false;
    }
}
