package Status;

import java.util.List;

import action.Reaction;
import modifier.Modifier;
import pokemon.Pokemon;
import prevent.Prevent;

public class Status implements Cloneable {
    protected List<Modifier> modifiers;
    protected List<Prevent> prevents;
    protected List<Reaction> reactions;

    protected Pokemon pokemon;

    public Status getInstance(Pokemon pokemon) {
        try {
            Status newStatus = (Status) super.clone();
            newStatus.pokemon = pokemon;
            return newStatus;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
