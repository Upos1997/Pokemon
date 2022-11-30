package ability.abilityLogic;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import action.Reaction;
import action.actionLogic.MessageAction;
import field.Field;
import modifier.Modifier;
import pokemon.Pokemon;
import prevent.Prevent;

public abstract class Ability {
    protected Ability(Pokemon user) {
        this.user = user;
    }

    protected Pokemon user;
    protected Predicate<Field> isActive;
    protected Predicate<Field> isDormant = field -> !isActive.test(field);
    protected MessageAction activeMessage;
    protected MessageAction dormantMessage;
    protected boolean active = false;

    protected List<Reaction> reactions = new ArrayList<>();
    protected List<Modifier> modifiers = new ArrayList<>();
    protected List<Prevent> prevents = new ArrayList<>();

    protected void addReaction(Field field, Reaction reaction) {
        reactions.add(reaction);
        field.addReaction(reaction);
    }

    protected void addModifier(Field field, Modifier modifier) {
        modifiers.add(modifier);
        field.addModifier(modifier);
    }

    protected void addPrevent(Field field, Prevent prevent) {
        prevents.add(prevent);
        field.addPrevent(prevent);
    }

    protected void removeAbility(Field field) {
        for (Reaction reaction : reactions) {
            field.removeReaction(reaction);
        }
        for (Modifier modifier : modifiers) {
            field.removeModifier(modifier);
        }
        for (Prevent prevent : prevents) {
            field.removePrevent(prevent);
        }
        reactions = new ArrayList<>();
        modifiers = new ArrayList<>();
        prevents = new ArrayList<>();
    }

    abstract protected void disableAbility(Field field);

    abstract protected void enableAbility(Field field);

    protected void deactivate(Field field) {
        removeAbility(field);
        if (active) {
            disableAbility(field);
        }
        active = false;
    }

    protected void dormant(Field field) {
        Predicate<Field> action = _field -> {
            activate(_field);
            return true;
        };
        removeAbility(field);
        addReaction(field, new Reaction(activeMessage, user, this, user, isActive, action));
        if (active) {
            disableAbility(field);
        }
        active = false;
    }

    protected void activate(Field field) {
        Predicate<Field> action = _field -> {
            dormant(_field);
            return true;
        };
        removeAbility(field);
        addReaction(field, new Reaction(dormantMessage, user, this, user, isDormant, action));
        enableAbility(field);
        active = true;
    }

    public void switchIn(Field field) {
        if (isActive.test(field)) {
            activate(field);
        } else {
            dormant(field);
        }
    }

    public void switchOut(Field field) {
        deactivate(field);
    }

    abstract public Ability newInstance(Pokemon user);
}
