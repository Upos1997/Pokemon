package src.combat.action.reaction;

import src.combat.field.Field;
import src.helper.Source;
import src.pokemon.Pokemon;

import java.util.function.Consumer;

public class ReactionNoCheck extends Reaction {
    public ReactionNoCheck(Pokemon user, Source source, Class<?> classCheck, Consumer<Field> action) {
        super(user, source, classCheck, (a, b) -> true, action);
    }
}
