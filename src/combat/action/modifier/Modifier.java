package src.combat.action.modifier;

import src.combat.action.prevent.Preventable;
import src.combat.field.Field;
import src.helper.Source;
import src.pokemon.Pokemon;

import java.util.function.BiFunction;
import java.util.function.Consumer;

public class Modifier implements Modifiable, Preventable {
    Modifier(Pokemon user, Source source, BiFunction<Field, Modifiable, Boolean> check, Consumer<Modifiable> action) {
        this.user = user;
        this.source = source;
        this.check = check;
        this.action = action;
    }

    protected Pokemon user;
    protected Source source;

    public Pokemon getUser() {
        return user;
    }

    public Source getSource() {
        return source;
    }

    BiFunction<Field, Modifiable, Boolean> check;
    Consumer<Modifiable> action;

    public void use(Field field, Modifiable modifiable){
        if (isAllowed(field)){
            getModifiers(field);
            if (check.apply(field, modifiable)){
                action.accept(modifiable);
            }
        }
    }
}
