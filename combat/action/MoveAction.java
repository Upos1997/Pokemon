package combat.action;

import java.util.List;

import combat.action.actionLogic.Action;
import combat.field.Field;
import combat.modifier.MessageModifier;
import combat.prevent.MessagePrevent;
import moves.moveLogic.Move;
import pokemon.Pokemon;
import pokemon.Type;

public class MoveAction extends Action {

    public MoveAction(Field field, Pokemon user, Move move, Pokemon target, List<Action> actions) {
        super(user, move, target);
        this.messages = List.of(MessagePrevent.MOVE);
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
