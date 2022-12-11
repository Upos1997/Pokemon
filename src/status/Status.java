package src.status;


import src.combat.field.SingleField;
import src.helper.Source;
import src.helper.Static;
import src.pokemon.Pokemon;

abstract public class Status extends Static implements Source {
    Status(Pokemon afflicted) {
        this.afflicted = afflicted;
    }

    protected Pokemon afflicted;

    public void switchIn(SingleField field) {
        afflict(field);
    }

    public void switchOut(SingleField field) {
        clearEffects(field);
    }

    protected void cure(SingleField field) {
        clearEffects(field);
    }

    abstract protected void afflict(SingleField field);

    abstract public Status getInstance(Pokemon pokemon);
}
