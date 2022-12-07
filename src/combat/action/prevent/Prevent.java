package src.combat.action.prevent;

import src.combat.action.Action;
import src.combat.action.Message;
import src.combat.action.reaction.Reaction;
import src.combat.field.Field;
import src.pokemon.Pokemon;

import java.util.function.BiFunction;
import java.util.function.Predicate;

public class Prevent extends Reaction {
    Prevent(Pokemon user, Object source, Message message, BiFunction<Field, Action, Boolean> check, Predicate<Field> action) {
        super(user, source, message, check, action);
    }
}
