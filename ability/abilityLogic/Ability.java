package ability.abilityLogic;

import java.util.function.Predicate;

import combat.action.Reaction;
import combat.action.actionLogic.MessageAction;
import combat.field.Field;
import helper.Static;
import pokemon.Pokemon;

public abstract class Ability extends Static {
    protected Ability(Pokemon user) {
        this.user = user;
    }

    protected Pokemon user;
    protected Predicate<Field> isActive;
    protected Predicate<Field> isDormant = field -> !isActive.test(field);
    protected MessageAction activeMessage;
    protected MessageAction dormantMessage;
    protected boolean active = false;

    abstract protected void disableAbility(Field field);

    abstract protected void enableAbility(Field field);

    protected void deactivate(Field field) {
        clearEffects(field);
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
        clearEffects(field);
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
        clearEffects(field);
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
