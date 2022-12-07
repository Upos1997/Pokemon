package src.moves.moveLogic;

import src.combat.field.Field;
import src.pokemon.Pokemon;

public abstract class moveStatus extends Move {

    static protected Boolean makesContact = false;

    @Override
    public boolean isStatus() {
        return true;
    }
}
