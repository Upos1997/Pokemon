package src.combat.action;

import src.combat.field.Field;
import src.pokemon.Pokemon;

public class ActionEndOfTurn extends Action {
    protected ActionEndOfTurn() {
        super(Pokemon.emptyPokemon, null);
    }
    @Override
    public Object takeAction(Field field) {
        return null;
    }
}
