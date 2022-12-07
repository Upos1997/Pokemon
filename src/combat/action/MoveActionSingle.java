package src.combat.action;

import src.combat.field.Field;
import src.moves.moveLogic.Move;
import src.pokemon.Pokemon;
import src.pokemon.Type;

import java.util.List;

public class MoveActionSingle extends ActionTargeted{
    MoveActionSingle(MoveAction action, Pokemon target) {
        super(action.user, action, target);
        move = action.getParent();
    }

    MoveAction source;
    Move move;

    @Override
    public MoveAction getParent() {
        return source;
    }

    public List<Type> getTypes(){
        return source.types;
    }
    boolean isHit(Field field){
        return new MoveActionHit(this).takeAction(field);
    }

    @Override
    public Boolean takeAction(Field field) {
        if (isHit(field)){
            return move.singleTarget(field, user, target, this);
        } else return false;
    }
}
