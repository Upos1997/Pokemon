package action;

import java.util.function.BiFunction;

import field.Field;
import pokemon.Pokemon;

public class ReactionNoCheck extends Reaction {
    public ReactionNoCheck(Pokemon user, BiFunction<Field, Action, Void> action) {
        super(user, noCheck, action);
    }

}
