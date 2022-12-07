package src.combat.action.prevent;

import src.combat.action.Action;
import src.combat.action.Message;
import src.combat.field.Field;
import src.pokemon.Pokemon;

import java.util.function.BiFunction;

public class PreventNoAction extends Prevent{

    PreventNoAction(Pokemon user, Object source, Message message, BiFunction<Field, Action, Boolean> check) {
        super(user, source, message, check, Prevent.noAction);
    }
}
