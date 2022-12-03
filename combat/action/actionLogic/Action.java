package combat.action.actionLogic;

import java.util.List;
import java.util.function.Predicate;

import combat.field.Field;
import combat.modifier.MessageModifier;
import combat.modifier.Modifier;
import combat.prevent.MessagePrevent;
import pokemon.Pokemon;

public abstract class Action {
    protected Action(Pokemon user, Object source, Pokemon target) {
        this.user = user;
        this.source = source;
        this.target = target;
    }

    protected Object source;
    protected Pokemon user;
    protected Pokemon target;
    protected List<MessagePrevent> messages;
    protected int priority;

    public Pokemon getUser() {
        return user;
    }

    public Object getSource() {
        return source;
    }

    public Pokemon getTarget() {
        return target;
    }

    public int getPriority() {
        return priority;
    }

    public double doubleAdjustedValue(Field field, double baseValue, MessageModifier message) {
        double result = baseValue;
        for (Modifier modifier : field.getModifiers(message)) {
            result *= modifier.getModifier();
        }
        return result;
    }

    public boolean isAllowed(Field field) {
        Predicate<MessagePrevent> filter = message -> field.isAllowed(this, message);
        return messages.stream().noneMatch(filter);
    }

    public boolean hasUser(Pokemon pokemon) {
        return user.equals(pokemon);
    }

    public boolean takeAction(Field field) {
        field.setCurrentAction(this);
        if (isAllowed(field)) {
            return action(field);
        } else
            return false;
    }

    abstract protected boolean action(Field field);
}
