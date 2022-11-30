package Status;

import java.util.List;

import action.Reaction;
import field.Field;
import modifier.Modifier;
import pokemon.Pokemon;
import prevent.Prevent;

abstract public class Status {
    Status(Pokemon afflicted) {
        this.afflicted = afflicted;
    }

    protected List<Modifier> modifiers;
    protected List<Prevent> prevents;
    protected List<Reaction> reactions;

    protected Pokemon afflicted;

    public void switchIn(Field field) {
        afflict(field);
    }

    public void switchOut(Field field) {
        cure(field);
    }

    abstract protected void afflict(Field field);

    abstract protected void cure(Field field);

    abstract public Status getInstance(Pokemon pokemon);
}
