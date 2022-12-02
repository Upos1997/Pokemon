package trainer;

import java.util.ArrayList;
import java.util.List;

import action.actionLogic.Action;
import field.Field;
import pokemon.Pokemon;

public abstract class Trainer {
    List<Pokemon> party = new ArrayList<>();

    abstract public Action takeAction(Field field);

    public Pokemon getFirstPokemon() {
        return party.get(0);
    }
}
