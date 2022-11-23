package action;

import java.util.List;

import field.Field;
import moves.moveLogic.Move;
import pokemon.Pokemon;
import pokemon.Type;

public class ActionMove extends Action{

    ActionMove(Pokemon user, Move move, List<Pokemon> targets) {
        super(user, targets, noAction);
        this.move = move;
    }
    
    public Move move;

   
    public Void takeAction(Field field) {
        Runnable beforeAction = () -> field.handleReactions(MessageReaction.BATTACK, this);
        Runnable afterAction = () -> field.handleReactions(MessageReaction.AATTACK, this);
        return super.takeAction(field, beforeAction, afterAction);
    }
    
    public boolean isUser(Pokemon pokemon){
        return user == pokemon;
    }

    public boolean isType(Type type){
        return move.isType(type);
    }
}
