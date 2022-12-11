package src.combat.action.modifier;

import src.combat.action.base.BaseSource1Pokemon;
import src.combat.action.prevent.Preventable;
import src.combat.field.Field;
import src.helper.Source;
import src.pokemon.Pokemon;

import java.util.function.BiFunction;
import java.util.function.Consumer;

public class Modifier extends BaseSource1Pokemon implements Modifiable, Preventable {
    Modifier(Pokemon user, Source source, Class<?> classCheck, BiFunction<Field, Modifiable, Boolean> check, Consumer<Modifiable> action) {
        super(user, source);
        this.classCheck = classCheck;
        this.check = check;
        this.action = action;
    }

    protected Class<?> classCheck;

    public Class<?> getClassCheck() {
        return classCheck;
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
