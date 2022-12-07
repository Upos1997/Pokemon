package src.status;

import src.combat.field.SingleField;
import src.pokemon.Pokemon;

public class Fainted extends Status {

    Fainted(Pokemon afflicted) {
        super(afflicted);
    }

    @Override
    protected void afflict(SingleField field) {
    }

    @Override
    public Fainted getInstance(Pokemon pokemon) {
        return new Fainted(pokemon);
    }

}
