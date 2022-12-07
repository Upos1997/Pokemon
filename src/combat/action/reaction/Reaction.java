package src.combat.action.reaction;

import src.combat.action.Action;
import src.combat.field.Field;
import src.pokemon.Pokemon;

import java.util.function.BiFunction;
import java.util.function.Predicate;

public class Reaction extends Action {


    public Reaction(Pokemon user, Object source, BiFunction<Field, Action, Boolean> check, Predicate<Field> action) {
        super(user, source);
        this.action = action;
        this.check = check;
    }

    protected Predicate<Field> action;
    protected BiFunction<Field, Action, Boolean> check;
    static public Predicate<Field> noAction = field -> true;
    static public BiFunction<Field, Action, Boolean> noCheck = (field, action1) -> true;


    public boolean check(Field field, Action action){
        return check.apply(field, action);
    }
    @Override
    public Boolean takeAction(Field field) {
        return action.test(field);
    }
    public boolean checkThenUse(Field field, Action action){
        if (check(field, action)){
            return (boolean) action(field);
        } else {
            return false;
        }
    }
}
