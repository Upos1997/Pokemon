package moves.moveLogic;

import java.util.List;

import action.ActionHit;
import action.actionLogic.Action;
import field.Field;
import field.Slot;
import pokemon.Pokemon;
import pokemon.Type;

public abstract class Move implements Cloneable {

    static protected List<Type> types;
    static protected Targetting target = Targetting.ADJACENT;
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

    static protected double critChance = 1 / 24;
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

    public void use(Field field, Pokemon user, List<Pokemon> targets) {
        for (Pokemon target : targets) {
            List<Action> actions = makeActions(user, target);
            for (Action action : actions) {
                field.setCurrentAction(action);
                action.takeAction(field);
            }
        }
    }

    public void recharge() {
        ppCurrent = ppMax;
    }

    abstract protected List<Action> makeActions(Pokemon user, Pokemon target);

    protected Action toHit(Pokemon user, Pokemon target) {
        return new ActionHit(user, this, target);
    }

    @Override
    public Move clone() {
        try {
            return (Move) super.clone();
        } catch (CloneNotSupportedException e) {

        }
        return null;
    }

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
}
