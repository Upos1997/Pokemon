package moves.moveLogic;

import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

import field.Field;
import field.Slot;
import helper.Rng;
import modifier.Modifier;
import pokemon.Pokemon;
import pokemon.Stat;
import pokemon.Type;

public abstract class Move implements Cloneable {

    protected List<Type> types;
    protected Targetting target = Targetting.ADJACENT;
    protected double accuracy = 1;
    protected int ppMax;
    protected int ppCurrent;
    protected int power;
    protected boolean makesContact;
    protected boolean autoHit = false;
    protected int priority = 0;

    static protected double critChance = 1 / 24;
    static protected double critDamage = 1.5;
    static protected double stab = 1.5;
    static protected double drain = 0.5;
    static protected double randomLow = 0.85;
    static protected int randomHigh = 1;
    static protected List<Type> additionalTypes = Collections.emptyList();
    static protected Boolean autoHitOnce = false;
    static protected double damageModifier = 1;

    protected List<Modifier> modifiers = Collections.emptyList();

    public List<Type> getTypes() {
        List<Type> result = Collections.emptyList();
        result.addAll(types);
        result.addAll(additionalTypes);
        return result;
    }

    public List<Slot> getTargets(Field field, Pokemon user) {
        return target.getTargets(field, user);
    }

    private void updateModifiers(List<Modifier> modifiers, BiFunction<Double, Double, Double> updateModifiers,
            Boolean autohit) {
        for (Modifier modifier : modifiers) {
            double mod = modifier.getmodifier();
            Function<Double, Double> update = (baseStat) -> {
                return updateModifiers.apply(baseStat, mod);
            };
            switch (modifier.getMessage()) {
                case ACCURACY:
                    accuracy = update.apply(accuracy);
                case AUTO_HIT:
                    autoHitOnce = autohit;
                case CRIT_CHANCE:
                    critChance = update.apply(critChance);
                case CRIT_DAMAGE:
                    critDamage = update.apply(critDamage);
                case DRAIN:
                    drain = update.apply(drain);
                case POWER:
                    damageModifier = update.apply(damageModifier);
            }
        }
    }

    private void applyModifiers(Field field, List<Modifier> modifiers) {
        this.modifiers = modifiers;
        updateModifiers(modifiers, (Double baseStat, Double mod) -> {
            return baseStat * mod;
        }, true);
    }

    private void revertModifiers() {
        updateModifiers(modifiers, (Double baseStat, Double mod) -> {
            return baseStat / mod;
        }, false);
        modifiers = Collections.emptyList();
    }

    private boolean canUse() {
        return ppCurrent > 0;
    }

    private boolean isHit(Pokemon user, Pokemon target) {
        if (autoHitOnce || autoHit) {
            return true;
        } else {
            return Rng.chance(accuracy * Stat.getAccMod(user.getStage(Stat.ACCURACY), target.getStage(Stat.EVASION)));
        }
    }

    public void use(Field field, Pokemon user, List<Pokemon> targets, List<Modifier> modifiers) {
        if (canUse()) {
            ppCurrent--;
            applyModifiers(field, modifiers);
            for (Pokemon target : targets) {
                if (isHit(user, target)) {
                    onHit(field, user, target);
                }
            }
            revertModifiers();
        }
    }

    public void recharge() {
        ppCurrent = ppMax;
    }

    protected abstract void onHit(Field field, Pokemon user, Pokemon target);

    @Override
    public Move clone() {
        try {
            return (Move) super.clone();
        } catch (CloneNotSupportedException e) {

        }
        return null;
    }

    public boolean isType(Type type) {
        return types.contains(type);
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
}
