package modifier;

import java.util.function.Function;

import action.ActionMove;
import field.Field;
import moves.moveLogic.Move;

public class Modifier {
    public Modifier(MessageModifier message, Float modifier, Function<ActionMove, Boolean> check){
        this.message = message;
        this.modifier = modifier;
        this.check = check;
    }
    private MessageModifier message;
    private Float modifier;
    private Field field;
    private Function<ActionMove, Boolean> check;
    private Boolean singleUse = false;

    public Boolean check(ActionMove move){
        return check.apply(move);
    }

    public float getmodifier(){
        if (singleUse){
            remove();
        }
        return modifier;
    }

    public MessageModifier getMessage(){
        return message;
    }

    public Boolean remove(){
        this.field = null;
        return field.removeModifier(this);
    };

    public Boolean add(Field field){
        this.field = field;
        return field.addModifier(this);
    }

    public Boolean makeSingleUse(){
        return this.singleUse = true;
    }

    static final public Function<Move, Boolean> noCheck = (move) -> {return true;};
}
