package src.combat.action;

import src.combat.field.Field;
import src.helper.Source;
import src.pokemon.Pokemon;

public abstract class ActionTargeted<T> extends Action<T> {
    protected ActionTargeted(Pokemon user, Source source, Pokemon target) {
        super(user, source);
        this.target = target;
    }
    protected Pokemon target;

    public Pokemon getTarget(){
        return target;
    }

}
