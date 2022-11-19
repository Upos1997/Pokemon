package action;

import java.util.List;
import java.util.function.BiFunction;

import field.Field;
import moves.Move;
import pokemon.Pokemon;

public class ActionMove extends Action{

    ActionMove(Pokemon user, Move move, List<Pokemon> targets, BiFunction<Field, Action, Void> action) {
        super(user, action);
        this.move = move;
        this.targets = targets;
    }
    
    public Move move;
    public List<Pokemon> targets;
    
}
