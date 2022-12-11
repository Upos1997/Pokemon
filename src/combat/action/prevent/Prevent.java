package src.combat.action.prevent;

import src.combat.action.base.BaseSource1Pokemon;
import src.combat.field.Field;
import src.helper.Source;
import src.pokemon.Pokemon;

import java.util.function.BiFunction;
import java.util.function.Consumer;

public class Prevent extends BaseSource1Pokemon implements Preventable {
    Prevent(Pokemon user, Source source, BiFunction<Field, Preventable, Boolean> check, Consumer<Field> action) {
        super(user, source);
        this.check = check;
        this.action = action;
    }

    protected BiFunction<Field, Preventable, Boolean> check;
    Consumer<Field> action;

    public boolean use(Field field, Preventable preventable){
        if (check.apply(field, preventable) && isAllowed(field)){
            action.accept(field);
            return true;
        } else return false;
    }
}
