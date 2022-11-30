package Status;

import pokemon.Pokemon;

public class Poisoned extends BadlyPoisoned {
    Poisoned(Pokemon afflicted) {
        super(afflicted);
    }

    @Override
    protected void updatePoison() {
    }

    static protected float poisonDamage = 1 / 8;

    @Override
    public Poisoned getInstance(Pokemon pokemon) {
        return new Poisoned(pokemon);
    }
}
