package modifier;

import java.util.function.BiFunction;
import java.util.function.Function;

import action.ActionMove;
import field.Field;

public class ModifierMove extends Modifier{
    ModifierMove(Field field, MessageModifier message, Float modifier, BiFunction<Field, ActionMove, Boolean> check){
        this.message = message;
        this.modifier = modifier;
        this.check = (action) -> {return check.apply(field, action);};
        super.add(field);
    }

    Function<ActionMove, Boolean> check;

    Boolean check(ActionMove action){
        return check.apply(action);
    }
    
}
