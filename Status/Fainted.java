package Status;

import field.Field;
import pokemon.Pokemon;

public class Fainted extends Status {

    Fainted(Pokemon afflicted) {
        super(afflicted);
    }

    @Override
    protected void afflict(Field field) {
    }

    @Override
    public Fainted getInstance(Pokemon pokemon) {
        return new Fainted(pokemon);
    }

}
