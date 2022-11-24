package action;

import java.util.List;
import java.util.stream.Collectors;

import field.Field;
import field.Slot;
import moves.moveLogic.Move;
import pokemon.Pokemon;
import pokemon.Type;

public class ActionMove extends Action {

    ActionMove(Field field, Pokemon user, Move move, List<Slot> targets) {
        super(user);
        this.move = move;
        this.targets = targets;

    }

    private Move move;
    private List<Slot> targets;

    public Void takeAction(Field field) {
        Runnable beforeAction = () -> field.handleReactions(MessageAction.BATTACK, this);
        Runnable afterAction = () -> field.handleReactions(MessageAction.AATTACK, this);
        return super.takeAction(field, beforeAction, afterAction);
    }

    public boolean isType(Type type) {
        return move.isType(type);
    }

    @Override
    Void action(Field field) {
        field.handleReactions(MessageAction.BATTACK, this);
        List<Pokemon> targets = this.targets.stream().map((Slot target) -> {
            return target.getPokemon();
        }).collect(Collectors.toList());
        move.use(field, user, targets, null);
        field.handleReactions(MessageAction.AATTACK, this);
    }
}
