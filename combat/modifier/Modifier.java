package modifier;

import java.util.function.Function;

import field.Field;
import moves.moveLogic.Move;

public class Modifier {
    Modifier(MessageModifier message, Float modifier, Function<Move, Boolean> check){
        this.message = message;
        this.modifier = modifier;
        this.check = check;
    }
    private MessageModifier message;
    private Float modifier;
    private Field field;
    private Function<Move, Boolean> check;
    private Boolean singleUse = false;

    public Boolean check(Move move){
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
        return field.removeModifier(message, this);
    };

    public Boolean add(Field field){
        this.field = field;
        return field.addModifier(message, this);
    }

    public Boolean makeSingleUse(){
        return this.singleUse = true;
    }

    static final public Function<Move, Boolean> noCheck = (move) -> {return true;};
}
