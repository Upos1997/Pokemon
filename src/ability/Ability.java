package src.ability;

import java.util.function.Predicate;

import src.combat.action.reaction.Reaction;
import src.combat.field.SingleField;
import src.helper.Source;
import src.helper.Static;
import src.pokemon.Pokemon;

public abstract class Ability extends Static implements Source {
    protected Ability(Pokemon user) {
        this.user = user;
    }

    protected Pokemon user;
    protected Predicate<SingleField> isActive;
    protected Predicate<SingleField> isDormant = field -> !isActive.test(field);
    protected boolean active = false;

    abstract protected void disableAbility(SingleField field);

    abstract protected void enableAbility(SingleField field);

    protected void deactivate(SingleField field) {
        clearEffects(field);
        if (active) {
            disableAbility(field);
        }
        active = false;
    }

    protected void dormant(SingleField field) {
        Predicate<SingleField> action = _field -> {
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

    protected void activate(SingleField field) {
        Predicate<SingleField> action = _field -> {
            dormant(_field);
            return true;
        };
        clearEffects(field);
        addReaction(field, new Reaction(dormantMessage, user, this, user, isDormant, action));
        enableAbility(field);
        active = true;
    }

    public void switchIn(SingleField field) {
        if (isActive.test(field)) {
            activate(field);
        } else {
            dormant(field);
        }
    }

    public void switchOut(SingleField field) {
        deactivate(field);
    }

    abstract public Ability newInstance(Pokemon user);
}
