package src.combat.action.modifier;

import src.combat.action.Action;
import src.combat.action.Message;
import src.combat.action.reaction.Reaction;
import src.combat.field.Field;
import src.combat.field.SingleField;
import src.pokemon.Pokemon;

import java.util.function.BiFunction;
import java.util.function.Predicate;

public abstract class Modifier extends Reaction {
    Modifier(Pokemon user, Object source, float modifier, BiFunction<Field, Action, Boolean> check, Predicate<Field> action) {
        super(user, source, check, action);
        this.modifier = modifier;
    }

    float modifier;

    public float getModifier() {
        return modifier;
    }

    public abstract void undo();
}
