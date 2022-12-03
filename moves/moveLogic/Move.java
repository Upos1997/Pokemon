package moves.moveLogic;

import java.util.List;


import combat.action.MoveAction;
import combat.action.actionLogic.Action;
import combat.field.Field;
import combat.field.Slot;
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

    public void use(Field field, Pokemon user, List<Pokemon> targets, Action type) {
        if (makeMoveAction(field, user, user).isAllowed(field))
            for (Pokemon target : targets) {
                MoveAction action = makeMoveAction(field, user, target);
                field.setCurrentAction(action);
                action.takeAction(field);
            }

    }

    protected MoveAction makeMoveAction(Field field, Pokemon user, Pokemon target) {
        return new MoveAction(field, user, this, target, makeActions(user, target));
    }

    abstract protected List<Action> makeActions(Pokemon user, Pokemon target);

    @Override
    public Move clone() {
        try {
            return (Move) super.clone();
        } catch (CloneNotSupportedException ignored) {

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
