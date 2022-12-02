package action.actionLogic;

import java.util.List;
import java.util.function.Predicate;

import field.Field;
import modifier.MessageModifier;
import modifier.Modifier;
import modifier.ModifierType;
import pokemon.Pokemon;
import pokemon.Type;
import prevent.MessagePrevent;

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
            result *= modifier.getmodifier();
        }
        return result;
    }

    public List<Type> typeAdjustedValue(Field field, List<Type> baseValue, MessageModifier message) {
        List<Type> result = baseValue;
        for (Modifier modifier : field.getModifiers(message)) {
            ModifierType _modifier = (ModifierType) modifier;
            result = List.of(_modifier.getModifier());
        }
        return result;
    }

    public boolean isAllowed(Field field) {
        Predicate<MessagePrevent> filter = message -> field.isAllowed(this, message);
        return !messages.stream().filter(filter).findAny().isPresent();
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
