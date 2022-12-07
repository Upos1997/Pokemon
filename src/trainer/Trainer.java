package src.trainer;

import java.util.ArrayList;
import java.util.List;

import src.combat.action.Action;
import src.combat.field.SingleField;
import src.pokemon.Pokemon;

public abstract class Trainer {
    List<Pokemon> party = new ArrayList<>();

    abstract public Action takeAction(SingleField field);

    public Pokemon getFirstPokemon() {
        return party.get(0);
    }
}
