package src.status;


import src.combat.field.SingleField;
import src.pokemon.Pokemon;

public class Ok extends Status {
    Ok(Pokemon afflicted) {
        super(afflicted);
    }

    @Override
    protected void afflict(SingleField field) {
    }

    @Override
    public Ok getInstance(Pokemon pokemon) {
        return new Ok(pokemon);
    }

}
