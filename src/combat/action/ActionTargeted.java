package src.combat.action;

import src.combat.field.Field;
import src.pokemon.Pokemon;

public abstract class ActionTargeted extends Action {
    protected ActionTargeted(Pokemon user, Object parent, Pokemon target) {
        super(user, parent);
        this.target = target;
    }
    Pokemon target;

    @Override
    protected void handleReactions(Field field) {
        super.handleReactions(field);
        target.handleReactions(field, this);
    }
}
