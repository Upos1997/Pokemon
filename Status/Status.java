package status;


import combat.field.Field;
import helper.Static;
import pokemon.Pokemon;

abstract public class Status extends Static {
    Status(Pokemon afflicted) {
        this.afflicted = afflicted;
    }

    protected Pokemon afflicted;

    public void switchIn(Field field) {
        afflict(field);
    }

    public void switchOut(Field field) {
        clearEffects(field);
    }

    protected void cure(Field field) {
        clearEffects(field);
    }

    abstract protected void afflict(Field field);

    abstract public Status getInstance(Pokemon pokemon);
}
