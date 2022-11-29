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
        super(user, move, target);
        this.messages = messages;
    }

    private List<Type> additionalTypes = Collections.emptyList();
    private Type overwriteType = null;

    @Override
    public Move getSource() {
        return (Move) source;
    }

    public Pokemon getTarget() {
        return target;
    }

    public List<Type> getTypes() {
        List<Type> result = Collections.emptyList();
        if (!overwriteType.equals(null)) {
            result.addAll(getSource().getTypes());
            result.addAll(additionalTypes);
        } else {
            result.add(overwriteType);
        }
        return result;
    }

    public boolean isType(Type type) {
        return getTypes().contains(type);
    }

    @Override
    protected boolean action(Field field) {
        return true;
    }
}
