package src.moves.moveLogic;

import java.util.List;

import src.combat.action.ActionMoveStatus;
import src.combat.field.Field;
import src.combat.field.Slot;
import src.helper.Source;
import src.pokemon.Pokemon;
import src.pokemon.Type;

public abstract class Move implements Source {

    static protected List<Type> types;
    static protected Targeting target = Targeting.ADJACENT;
    static protected float accuracy = 1;
    static protected int ppMax;
    static protected int ppCurrent = ppMax;
    static protected int priority = 0;

    public List<Type> getTypes() {
        return types;
    }
    public List<Slot> getTargets(Field field, Pokemon user) {
        return target.getTargets(field, user);
    }
    public float getAccuracy() {
        return accuracy;
    }
    public int getPriority() {
        return priority;
    }
    public void recharge() {
        ppCurrent = ppMax;
    }

    static protected float critChance = 1/24f;
    static protected float critDamage = 1.5f;
    static protected float stab = 1.5f;

    public float getCritChance() {
        return critChance;
    }

    public float getCritDamage() {
        return critDamage;
    }

    public float getStab() {
        return stab;
    }

    abstract public boolean use(Field field, Pokemon user, List<Pokemon> pokemons);
    abstract public boolean singleTarget(Field field, ActionMoveStatus action, Pokemon target);

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
