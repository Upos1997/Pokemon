package action.actionLogic;

import java.util.Collections;
import java.util.List;

import field.Field;
import moves.moveLogic.Move;
import pokemon.Pokemon;
import pokemon.Type;
import prevent.MessagePrevent;

public class MoveAction extends Action {

    public MoveAction(Pokemon user, Move move, Pokemon target, List<MessagePrevent> messages) {
        super(user);
        this.move = move;
        this.target = target;
        this.messages = messages;
    }

    private Move move;
    private Pokemon target;

    private List<Type> additionalTypes = Collections.emptyList();
    private Type overwriteType = null;

    public Move getMove() {
        return move;
    }

    public Pokemon getTarget() {
        return target;
    }

    public List<Type> getTypes() {
        List<Type> result = Collections.emptyList();
        if (!overwriteType.equals(null)) {
            result.addAll(move.getTypes());
            result.addAll(additionalTypes);
        } else {
            result.add(overwriteType);
        }
        return result;
    }

    public boolean isStatus() {
        return move.isStatus();
    }

    public boolean isPhysical() {
        return move.isPhysical();
    }

    public boolean isSpecial() {
        return move.isSpecial();
    }

    public boolean isType(Type type) {
        return move.isType(type);
    }

    @Override
    boolean action(Field field) {
        return false;
    }
}
