package src.combat.action.reaction;

import src.combat.action.base.BaseSource1Pokemon;
import src.combat.action.modifier.Modifiable;
import src.combat.action.prevent.Preventable;
import src.combat.field.Field;
import src.helper.Source;
import src.pokemon.Pokemon;

import java.util.function.BiFunction;
import java.util.function.Consumer;

public class Reaction extends BaseSource1Pokemon implements Reactionable, Preventable, Modifiable {


    public Reaction(Pokemon user, Source source, Class<?> classCheck, BiFunction<Field, Reactionable, Boolean> check, Consumer<Field> action) {
        super(user, source);
        this.classCheck = classCheck;
        this.action = action;
        this.check = check;
    }

    protected Class<?> classCheck;

    public Class<?> getClassCheck() {
        return classCheck;
    }

    protected Consumer<Field> action;
    protected BiFunction<Field, Reactionable, Boolean> check;
    static public BiFunction<Field, Reactionable, Boolean> noCheck = (field, action1) -> true;

    public void use(Field field, Reactionable reactionable){
        if (check.apply(field, reactionable) && isAllowed(field)){
            getModifiers(field);
            action.accept(field);
            handleReactions(field);
        }
    }
}
