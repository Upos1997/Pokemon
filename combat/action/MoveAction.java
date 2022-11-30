package action;

import java.util.List;

import action.actionLogic.Action;
import field.Field;
import modifier.MessageModifier;
import moves.moveLogic.Move;
import pokemon.Pokemon;
import pokemon.Type;
import prevent.MessagePrevent;

public class MoveAction extends Action {

    public MoveAction(Field field, Pokemon user, Move move, Pokemon target, List<Action> actions) {
        super(user, move, target);
        this.messages = List.of(MessagePrevent.MOVE);
        this.types = typeAdjustedValue(field, move.getTypes(), MessageModifier.TYPE);
        this.actions = actions;
    }

    @Override
    public Move getSource() {
        return (Move) source;
    }

    protected List<Type> types;
    protected List<Action> actions;

    public List<Type> getTypes() {
        return types;
    }

    public Pokemon getTarget() {
        return target;
    }

    @Override
    protected boolean action(Field field) {
        if (new ActionHit(user, getSource(), target).takeAction(field)) {
            for (Action action : actions) {
                action.takeAction(field);
            }
            return true;
        } else
            return false;
    }

    public boolean isType(Type type) {
        return types.contains(type);
    }
}
