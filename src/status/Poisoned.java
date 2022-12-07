package src.status;

import src.combat.field.SingleField;
import src.pokemon.Pokemon;

public class Poisoned extends BadlyPoisoned {
    Poisoned(Pokemon afflicted) {
        super(afflicted);
    }

    @Override
    protected void updatePoison() {
    }

    static protected float basePoisonDamage = 1 / 8;

    @Override
    public void switchOut(SingleField field) {
        super.switchOut(field);
    }

    @Override
    public Poisoned getInstance(Pokemon pokemon) {
        return new Poisoned(pokemon);
    }
}
