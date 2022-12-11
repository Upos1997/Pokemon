package src.combat.action.prevent;

import src.combat.field.Field;
import src.helper.Source;
import src.pokemon.Pokemon;

import java.util.function.BiFunction;

public class PreventNoAction extends Prevent{
    PreventNoAction(Pokemon user, Source source, BiFunction<Field, Preventable, Boolean> check) {
        super(user, source, check, field -> {});
    }
}
