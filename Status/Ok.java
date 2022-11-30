package Status;

import field.Field;
import pokemon.Pokemon;

public class Ok extends Status {
    Ok(Pokemon afflicted) {
        super(afflicted);
    }

    @Override
    protected void afflict(Field field) {
    }

    @Override
    public Ok getInstance(Pokemon pokemon) {
        return new Ok(pokemon);
    }

}
