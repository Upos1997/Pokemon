package src.combat.action;

import src.combat.field.Field;
import src.pokemon.Pokemon;

public abstract class ActionTargeted extends Action {
    protected ActionTargeted(Pokemon user, Object source, Pokemon target) {
        super(user, source);
        this.target = target;
    }
    protected Pokemon target;

    public Pokemon getTarget(){
        return target;
    }

    @Override
    protected void handleReactions(Field field) {
        super.handleReactions(field);
        target.handleReactions(field, this);
    }
}
