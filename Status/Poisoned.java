package status;

import field.Field;
import pokemon.Pokemon;

public class Poisoned extends BadlyPoisoned {
    Poisoned(Pokemon afflicted) {
        super(afflicted);
    }

    @Override
    protected void updatePoison() {
    }

    static protected float basePoisonDamage = 1 / 8;

    @Override
    public void switchOut(Field field) {
        super.switchOut(field);
    }

    @Override
    public Poisoned getInstance(Pokemon pokemon) {
        return new Poisoned(pokemon);
    }
}
