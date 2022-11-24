package action;

import java.util.List;

import field.Field;
import moves.moveLogic.Move;
import pokemon.Pokemon;
import pokemon.Type;

public class ActionMove extends Action {

    ActionMove(Field field, Pokemon user, Move move) {
        super(user, move.getTargets(field, user), (Field field) -> {
            List<Pokemon> targets = 
            return null;
        });
        this.move = move;
        
    }

    public Move move;

    public Void takeAction(Field field) {
        Runnable beforeAction = () -> field.handleReactions(MessageAction.BATTACK, this);
        Runnable afterAction = () -> field.handleReactions(MessageAction.AATTACK, this);
        return super.takeAction(field, beforeAction, afterAction);
    }

    public boolean isUser(Pokemon pokemon) {
        return user == pokemon;
    }

    public boolean isType(Type type) {
        return move.isType(type);
    }
}
